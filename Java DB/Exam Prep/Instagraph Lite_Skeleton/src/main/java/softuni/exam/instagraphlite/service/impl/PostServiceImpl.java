package softuni.exam.instagraphlite.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.picture.Picture;
import softuni.exam.instagraphlite.models.post.ImportPostDTO;
import softuni.exam.instagraphlite.models.post.ImportPostRootDTO;
import softuni.exam.instagraphlite.models.post.Post;
import softuni.exam.instagraphlite.models.user.User;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.repository.PostRepository;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.PostService;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.Set;

@Service
public class PostServiceImpl implements PostService {
    private final Path path = Path.of("src", "main", "resources", "files", "posts.xml");

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final PictureRepository pictureRepository;

    private final Unmarshaller unmarshaller;
    private final ModelMapper modelMapper;
    private final Validator validator;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository, PictureRepository pictureRepository) throws JAXBException {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.pictureRepository = pictureRepository;

        JAXBContext context = JAXBContext.newInstance(ImportPostRootDTO.class);
        this.unmarshaller = context.createUnmarshaller();

        this.modelMapper = new ModelMapper();

        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Override
    public boolean areImported() {
        return this.postRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(path);
    }

    @Override
    public String importPosts() throws IOException, JAXBException {
        StringBuilder result = new StringBuilder();

        ImportPostRootDTO postDTOS = (ImportPostRootDTO) this.unmarshaller.unmarshal(
                new FileReader(path.toAbsolutePath().toString()));

        postDTOS
                .getPosts()
                .stream()
                .map(this::importPost)
                .forEach(r -> result.append(r).append(System.lineSeparator()));

        return result.toString().trim();
    }

    private String importPost(ImportPostDTO importPostDTO) {
        Set<ConstraintViolation<ImportPostDTO>> constraintViolation = this.validator.validate(importPostDTO);

        if (constraintViolation.isEmpty()) {
            Optional<User> optionalUser = userRepository.findByUsername(importPostDTO.getUser().getUsername());
            Optional<Picture> optionalPicture = pictureRepository.findByPath(importPostDTO.getPicture().getPath());

            if (optionalUser.isPresent() && optionalPicture.isPresent()) {
                Post post = this.modelMapper.map(importPostDTO, Post.class);
                post.setUser(optionalUser.get());
                post.setPicture(optionalPicture.get());

                this.postRepository.save(post);
                return "Successfully imported Post, made by " + post.getUser().getUsername();
            } else {
                return "Invalid Post";
            }
        } else {
            return "Invalid Post";
        }
    }
}
