package exam.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import exam.model.laptop.ImportLaptopDTO;
import exam.model.laptop.Laptop;
import exam.model.laptop.WarrantyType;
import exam.model.shop.Shop;
import exam.repository.LaptopRepository;
import exam.repository.ShopRepository;
import exam.service.LaptopService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class LaptopServiceImpl implements LaptopService {

    private final Path path = Path.of("src", "main", "resources", "files", "json", "laptops.json");

    private final LaptopRepository laptopRepository;
    private final ShopRepository shopRepository;

    private final Gson gson;
    private final ModelMapper modelMapper;
    private final Validator validator;

    @Autowired
    public LaptopServiceImpl(LaptopRepository laptopRepository, ShopRepository shopRepository) {
        this.laptopRepository = laptopRepository;
        this.shopRepository = shopRepository;

        this.gson = new GsonBuilder().create();
        this.modelMapper = new ModelMapper();
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Override
    public boolean areImported() {
        return this.laptopRepository.count() > 0;
    }

    @Override
    public String readLaptopsFileContent() throws IOException {
        return Files.readString(path);
    }

    @Override
    public String importLaptops() throws IOException {
        StringBuilder result = new StringBuilder();

        String json = this.readLaptopsFileContent();

        ImportLaptopDTO[] laptopDTOs = gson.fromJson(json, ImportLaptopDTO[].class);

        Arrays.stream(laptopDTOs)
                .map(this::importLaptop)
                .forEach(r -> result.append(r).append(System.lineSeparator()));

        return result.toString().trim();
    }

    private String importLaptop(ImportLaptopDTO importLaptopDTO) {

        Set<ConstraintViolation<ImportLaptopDTO>> constraintViolations = this.validator.validate(importLaptopDTO);

        if (constraintViolations.isEmpty()) {

            Optional<Laptop> optionalLaptop = this.laptopRepository.findByMacAddress(importLaptopDTO.getMacAddress());

            if (optionalLaptop.isEmpty()) {

                Laptop laptop = this.modelMapper.map(importLaptopDTO, Laptop.class);
                Shop shop = this.shopRepository.findByName(importLaptopDTO.getShop().getName()).get();
                WarrantyType warrantyType;

                try {
                    warrantyType = WarrantyType.valueOf(importLaptopDTO.getWarrantyType());
                } catch (IllegalArgumentException e) {
                    return "Invalid Laptop";
                }

                laptop.setShop(shop);
                laptop.setWarrantyType(warrantyType);
                this.laptopRepository.save(laptop);

                return String.format("Successfully imported Laptop %s - %.2f - %d - %d", laptop.getMacAddress(),
                        laptop.getCpuSpeed(), laptop.getRam(), laptop.getStorage());
            } else {
                return "Invalid Laptop";
            }
        } else {
            return "Invalid Laptop";
        }
    }

    @Override
    public String exportBestLaptops() {
        List<Laptop> laptops = this.laptopRepository.getAllOrderByCpuSpeedDescRamDescStorageDescMacAddressAsc();
        return laptops
                .stream()
                .map(Laptop::toString)
                .collect(Collectors.joining("\n"));
    }
}
