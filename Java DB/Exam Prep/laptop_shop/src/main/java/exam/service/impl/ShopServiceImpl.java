package exam.service.impl;

import exam.model.shop.ImportShopDTO;
import exam.model.shop.ImportShopRootDTO;
import exam.model.shop.Shop;
import exam.model.town.ImportTownRootDTO;
import exam.model.town.Town;
import exam.repository.ShopRepository;
import exam.repository.TownRepository;
import exam.service.ShopService;
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
import java.util.Optional;
import java.util.Set;

@Service
public class ShopServiceImpl implements ShopService {

    private final Path path = Path.of("src", "main", "resources", "files", "xml", "shops.xml");

    private final ShopRepository shopRepository;
    private final TownRepository townRepository;

    private final Unmarshaller unmarshaller;
    private final ModelMapper modelMapper;
    private final Validator validator;

    @Autowired
    public ShopServiceImpl(ShopRepository shopRepository, TownRepository townRepository) throws JAXBException {
        this.shopRepository = shopRepository;
        this.townRepository = townRepository;

        JAXBContext context = JAXBContext.newInstance(ImportShopRootDTO.class);
        this.unmarshaller = context.createUnmarshaller();

        this.modelMapper = new ModelMapper();

        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Override
    public boolean areImported() {
        return this.shopRepository.count() > 0;
    }

    @Override
    public String readShopsFileContent() throws IOException {
        return Files.readString(path);
    }

    @Override
    public String importShops() throws JAXBException, FileNotFoundException {

        StringBuilder result = new StringBuilder();

        ImportShopRootDTO shopDTOs = (ImportShopRootDTO) unmarshaller.unmarshal(
                new FileReader(path.toAbsolutePath().toString()));

        shopDTOs
                .getShops()
                .stream()
                .map(this::importShop)
                .forEach(r -> result.append(r).append(System.lineSeparator()));

        return result.toString().trim();
    }

    private String importShop(ImportShopDTO importShopDTO) {

        Set<ConstraintViolation<ImportShopDTO>> constraintViolations = this.validator.validate(importShopDTO);

        if (constraintViolations.isEmpty()) {
            Optional<Shop> optionalShop = this.shopRepository.findByName(importShopDTO.getName());

            if (optionalShop.isEmpty()) {

                Shop shop = this.modelMapper.map(importShopDTO, Shop.class);
                Town town = this.townRepository.findByName(importShopDTO.getTown().getName());

                shop.setTown(town);
                this.shopRepository.save(shop);

                return String.format("Successfully imported Shop %s - %s", shop.getName(), shop.getIncome());
            } else {
                return "Invalid Shop";
            }
        } else {
            return "Invalid Shop";
        }
    }
}
