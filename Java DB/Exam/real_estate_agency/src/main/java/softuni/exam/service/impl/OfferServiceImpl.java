package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportOfferDTO;
import softuni.exam.models.dto.ImportOfferRootDTO;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.ApartmentType;
import softuni.exam.models.entity.Offer;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.OfferService;
import softuni.exam.util.FileUtil;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {
    private final Path path = Path.of("src", "main", "resources", "files", "xml", "offers.xml");
    private final FileUtil fileUtil;
    private final OfferRepository offerRepository;
    private final ApartmentRepository apartmentRepository;
    private final AgentRepository agentRepository;
    private final Validator validator;
    private final ModelMapper modelMapper;

    @Autowired
    public OfferServiceImpl(FileUtil fileUtil, OfferRepository offerRepository, ApartmentRepository apartmentRepository, AgentRepository agentRepository, Validator validator, ModelMapper modelMapper) {
        this.fileUtil = fileUtil;
        this.offerRepository = offerRepository;
        this.apartmentRepository = apartmentRepository;
        this.agentRepository = agentRepository;
        this.validator = validator;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return fileUtil.readFile(path);
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        StringBuilder result = new StringBuilder();

        JAXBContext context = JAXBContext.newInstance(ImportOfferRootDTO.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        ImportOfferRootDTO offerDTOS = (ImportOfferRootDTO) unmarshaller.unmarshal(
                new FileReader(path.toAbsolutePath().toString()));

        offerDTOS
                .getOffers()
                .stream()
                .map(this::importOffer)
                .forEach(r -> result.append(r).append(System.lineSeparator()));

        return result.toString().trim();
    }

    private String importOffer(ImportOfferDTO importOfferDTO) {

        Set<ConstraintViolation<ImportOfferDTO>> constraintViolations = this.validator.validate(importOfferDTO);

        if (constraintViolations.isEmpty()) {
            Optional<Agent> optionalAgent = this.agentRepository.findByFirstName(importOfferDTO.getAgent().getName());
            if (optionalAgent.isPresent()) {

                //There is a constraint stating the id will always be valid
                Apartment apartment = this.apartmentRepository.getById(importOfferDTO.getApartment().getId());

                Offer offer = modelMapper.map(importOfferDTO, Offer.class);
                offer.setAgent(optionalAgent.get());
                offer.setApartment(apartment);

                this.offerRepository.save(offer);
                return String.format("Successfully imported offer %.2f", offer.getPrice());
            } else {
                return "Invalid offer";
            }
        } else {
            return "Invalid offer";
        }
    }

    @Override
    public String exportOffers() {
        List<Offer> threeRoomApartmentsOrderedByAreaDescAndPriceAsc =
        this.offerRepository.findByApartmentApartmentTypeOrderByApartmentAreaDescPriceAsc(ApartmentType.three_rooms);

        return threeRoomApartmentsOrderedByAreaDescAndPriceAsc
                .stream()
                .map(Offer::toString)
                .collect(Collectors.joining("\n"));
    }
}
