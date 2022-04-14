package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportApartmentDTO;
import softuni.exam.models.dto.ImportApartmentRootDTO;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.ApartmentType;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.ApartmentService;
import softuni.exam.util.FileUtil;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.Set;

@Service
public class ApartmentServiceImpl implements ApartmentService {
    private final Path path = Path.of("src", "main", "resources", "files", "xml", "apartments.xml");
    private final FileUtil fileUtil;
    private final ApartmentRepository apartmentRepository;
    private final TownRepository townRepository;
    private final Validator validator;
    private final ModelMapper modelMapper;

    @Autowired
    public ApartmentServiceImpl(FileUtil fileUtil, ApartmentRepository apartmentRepository, TownRepository townRepository, Validator validator, ModelMapper modelMapper) {
        this.fileUtil = fileUtil;
        this.apartmentRepository = apartmentRepository;
        this.townRepository = townRepository;
        this.validator = validator;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.apartmentRepository.count() > 0;
    }

    @Override
    public String readApartmentsFromFile() throws IOException {
        return this.fileUtil.readFile(path);
    }

    @Override
    public String importApartments() throws IOException, JAXBException {
        StringBuilder result = new StringBuilder();

        JAXBContext context = JAXBContext.newInstance(ImportApartmentRootDTO.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        ImportApartmentRootDTO apartmentDTOS = (ImportApartmentRootDTO) unmarshaller.unmarshal(
                new FileReader(path.toAbsolutePath().toString()));

        apartmentDTOS
                .getApartments()
                .stream()
                .map(this::importApartment)
                .forEach(r -> result.append(r).append(System.lineSeparator()));

        return result.toString().trim();
    }

    private String importApartment(ImportApartmentDTO importApartmentDTO) {
        Set<ConstraintViolation<ImportApartmentDTO>> constraintViolations = this.validator.validate(importApartmentDTO);

        if (constraintViolations.isEmpty()) {

            ApartmentType apartmentType;

            try {
                apartmentType = ApartmentType.valueOf(importApartmentDTO.getApartmentType());
            } catch (IllegalArgumentException e) {
                return "Invalid apartment";
            }

            //There is a constraint stating the town will be always valid
            Town town = this.townRepository.findByTownName(importApartmentDTO.getTown()).get();
            Optional<Apartment> optionalApartment = this.apartmentRepository.findByTownAndArea(town, importApartmentDTO.getArea());

            if (optionalApartment.isEmpty()) {
                Apartment apartment = this.modelMapper.map(importApartmentDTO, Apartment.class);

                apartment.setApartmentType(apartmentType);
                apartment.setTown(town);

                this.apartmentRepository.save(apartment);

                return String.format("Successfully imported apartment %s - %.2f", apartment.getApartmentType(), apartment.getArea());
            } else {
                return "Invalid apartment";
            }
        } else {
            return "Invalid apartment";
        }

    }
}
