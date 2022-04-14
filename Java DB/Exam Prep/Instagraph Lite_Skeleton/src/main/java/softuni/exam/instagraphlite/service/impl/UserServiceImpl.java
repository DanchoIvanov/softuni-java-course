package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.picture.Picture;
import softuni.exam.instagraphlite.models.post.Post;
import softuni.exam.instagraphlite.models.user.ImportUserDTO;
import softuni.exam.instagraphlite.models.user.User;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.repository.PostRepository;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.UserService;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    private final Path path = Path.of("src", "main", "resources", "files", "users.json");

    private final UserRepository userRepository;
    private final PictureRepository pictureRepository;
    private final PostRepository postRepository;

    private final Gson gson;
    private final ModelMapper modelMapper;
    private final Validator validator;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PictureRepository pictureRepository,
                           PostRepository postRepository) {
        this.userRepository = userRepository;
        this.pictureRepository = pictureRepository;
        this.postRepository = postRepository;

        this.gson = new GsonBuilder().create();
        this.modelMapper = new ModelMapper();
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Override
    public boolean areImported() {
        return this.userRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(path);
    }

    @Override
    public String importUsers() throws IOException {
        StringBuilder result = new StringBuilder();

        String json = this.readFromFileContent();

        ImportUserDTO[] userDTOS = this.gson.fromJson(json, ImportUserDTO[].class);

        Arrays.stream(userDTOS)
                .map(this::importUser)
                .forEach(r -> result.append(r).append(System.lineSeparator()));

        return result.toString().trim();
    }

    private String importUser(ImportUserDTO importUserDTO) {
        Set<ConstraintViolation<ImportUserDTO>> constraintViolations = this.validator.validate(importUserDTO);

        if (constraintViolations.isEmpty()) {
            Optional<User> optionalUser = this.userRepository.findByUsername(importUserDTO.getUsername());

            if (optionalUser.isEmpty()) {
                Optional<Picture> optionalPicture = this.pictureRepository.findByPath(importUserDTO.getProfilePicture());

                if (optionalPicture.isPresent()) {
                    User user = this.modelMapper.map(importUserDTO, User.class);
                    user.setProfilePicture(optionalPicture.get());
                    this.userRepository.save(user);

                    return "Successfully imported User: " + user.getUsername();
                } else {
                    return "Invalid User";
                }
            } else {
                return "Invalid User";
            }
        } else {
            return "Invalid User";
        }
    }

    @Override
    public String exportUsersWithTheirPosts() {
        StringBuilder result = new StringBuilder();
        List<User> users = this.userRepository.findAll();

        Map<String, List<Post>> userPosts = new HashMap<>();

        for (User user : users) {
            List<Post> posts = this.postRepository.findByUserOrderByPictureSize(user);
            userPosts.put(user.getUsername(), posts);
        }

        users.sort((o1, o2) -> {
            int result1 = Integer.compare(userPosts.get(o2.getUsername()).size(), userPosts.get(o1.getUsername()).size());
            if (result1 == 0) {
                result1 = Integer.compare(o1.getId(), o2.getId());
            }
            return result1;
        });

        for (User user : users) {
            List<Post> posts = userPosts.get(user.getUsername());

            result.append("User: ").append(user.getUsername()).append(System.lineSeparator());
            result.append("Post count: ").append(posts.size()).append(System.lineSeparator());

            for (Post post : posts) {
                result.append("==Post Details:").append(System.lineSeparator());
                result.append("----Caption: ").append(post.getCaption()).append(System.lineSeparator());
                result.append(String.format("----Picture Size: %.2f%n", post.getPicture().getSize()));
            }
        }

        return result.toString().trim();
    }
}
