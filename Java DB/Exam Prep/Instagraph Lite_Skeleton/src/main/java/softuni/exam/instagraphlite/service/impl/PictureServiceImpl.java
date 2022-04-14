package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.picture.ImportPictureDTO;
import softuni.exam.instagraphlite.models.picture.Picture;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.service.PictureService;

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

@Service
public class PictureServiceImpl implements PictureService {
    private final Path path = Path.of("src", "main", "resources", "files", "pictures.json");

    private final PictureRepository pictureRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final Validator validator;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;

        this.gson = new GsonBuilder().create();
        this.modelMapper = new ModelMapper();
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Override
    public boolean areImported() {
        return this.pictureRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(path);
    }

    @Override
    public String importPictures() throws IOException {
        StringBuilder result = new StringBuilder();

        String json = this.readFromFileContent();

        ImportPictureDTO[] pictureDTOS = this.gson.fromJson(json, ImportPictureDTO[].class);

        Arrays.stream(pictureDTOS)
                .map(this::importPicture)
                .forEach(r -> result.append(r).append(System.lineSeparator()));

        return result.toString().trim();
    }

    private String importPicture(ImportPictureDTO importPictureDTO) {

        Set<ConstraintViolation<ImportPictureDTO>> constraintViolations = this.validator.validate(importPictureDTO);

        if (constraintViolations.isEmpty()) {
            Optional<Picture> optionalPicture = this.pictureRepository.findByPath(importPictureDTO.getPath());

            if (optionalPicture.isEmpty()) {
                Picture picture = this.modelMapper.map(importPictureDTO, Picture.class);
                this.pictureRepository.save(picture);

                return String.format("Successfully imported Picture, with size %.2f", picture.getSize());
            } else {
                return "Invalid Picture";
            }
        } else {
            return "Invalid Picture";
        }
    }

    @Override
    public String exportPictures() {
        StringBuilder result = new StringBuilder();

        List<Picture> pictures = this.pictureRepository.findBySizeGreaterThanOrderBySizeAsc(30000);

        pictures.forEach(p -> result.append(String.format("%.2f - %s%n",p.getSize(), p.getPath())));

        return result.toString().trim();
    }
}
