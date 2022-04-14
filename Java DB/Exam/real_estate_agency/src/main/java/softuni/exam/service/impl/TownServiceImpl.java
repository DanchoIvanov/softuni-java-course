package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportTownDTO;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TownService;
import softuni.exam.util.FileUtil;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;

@Service
public class TownServiceImpl implements TownService {
    private final Path path = Path.of("src", "main", "resources", "files", "json", "towns.json");
    private final FileUtil fileUtil;
    private final TownRepository townRepository;
    private final Gson gson;
    private final Validator validator;
    private final ModelMapper modelMapper;

    @Autowired
    public TownServiceImpl(FileUtil fileUtil, TownRepository townRepository, Gson gson, Validator validator, ModelMapper modelMapper) {
        this.fileUtil = fileUtil;
        this.townRepository = townRepository;
        this.gson = gson;
        this.validator = validator;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return fileUtil.readFile(path);
    }

    @Override
    public String importTowns() throws IOException {
        StringBuilder result = new StringBuilder();

        String json = readTownsFileContent();

        ImportTownDTO[] townDTOS = this.gson.fromJson(json, ImportTownDTO[].class);

        Arrays.stream(townDTOS)
                .map(this::importTown)
                .forEach(r -> result.append(r).append(System.lineSeparator()));

        return result.toString().trim();
    }

    private String importTown(ImportTownDTO importTownDTO) {

        Set<ConstraintViolation<ImportTownDTO>> constraintViolations = this.validator.validate(importTownDTO);

        if (constraintViolations.isEmpty()) {
            Optional<Town> optionalTown = this.townRepository.findByTownName(importTownDTO.getTownName());
            if (optionalTown.isEmpty()) {
                Town town = this.modelMapper.map(importTownDTO, Town.class);
                townRepository.save(town);

                return String.format("Successfully imported town %s - %d",town.getTownName(), town.getPopulation());
            } else {
                return "Invalid town";
            }
        } else {
            return "Invalid town";
        }
    }
}
