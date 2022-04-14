package exam.service.impl;

import exam.model.town.ImportTownDTO;
import exam.model.town.ImportTownRootDTO;
import exam.model.town.Town;
import exam.repository.TownRepository;
import exam.service.TownService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

@Service
public class TownServiceImpl implements TownService {

    private final TownRepository townRepository;
    private final Unmarshaller unmarshaller;
    private final ModelMapper modelMapper;
    private final Validator validator;

    private final Path path = Path.of("src", "main", "resources", "files", "xml", "towns.xml");

    @Autowired
    public TownServiceImpl(TownRepository townRepository) throws JAXBException {
        this.townRepository = townRepository;

        JAXBContext context = JAXBContext.newInstance(ImportTownRootDTO.class);
        this.unmarshaller = context.createUnmarshaller();

        this.modelMapper = new ModelMapper();

        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Override
    public boolean areImported() {
        return this.townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(path);
    }

    @Override
    public String importTowns() throws JAXBException, FileNotFoundException {

        StringBuilder result = new StringBuilder();

        ImportTownRootDTO townDTOs = (ImportTownRootDTO) this.unmarshaller.unmarshal(
                new FileReader(path.toAbsolutePath().toString()));

        townDTOs
                .getTowns()
                .stream()
                .map(this::importTown)
                .forEach(r -> result.append(r).append(System.lineSeparator()));

        return result.toString().trim();
    }

    private String importTown(ImportTownDTO importTownDTO) {

        Set<ConstraintViolation<ImportTownDTO>> constraintViolations = this.validator.validate(importTownDTO);

        if (constraintViolations.isEmpty()) {
            Town town = this.modelMapper.map(importTownDTO, Town.class);
            this.townRepository.save(town);

            return "Successfully imported Town " + town.getName();
        } else {
            return "Invalid Town";
        }
    }
}
