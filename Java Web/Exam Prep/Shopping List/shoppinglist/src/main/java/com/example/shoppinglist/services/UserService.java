package com.example.shoppinglist.services;

import com.example.shoppinglist.models.User;
import com.example.shoppinglist.models.dto.LoginDTO;
import com.example.shoppinglist.models.dto.RegistrationDTO;
import com.example.shoppinglist.models.mappers.UserMapper;
import com.example.shoppinglist.repositories.UserRepository;
import com.example.shoppinglist.users.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;
    private CurrentUser currentUser;
    private PasswordEncoder passwordEncoder;
    private UserMapper userMapper;

    public UserService(UserRepository userRepository,
                       CurrentUser currentUser,
                       PasswordEncoder passwordEncoder,
                       UserMapper userMapper) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    public void registerAndLogin(RegistrationDTO registrationDTO) {

        User newUser = userMapper.userDtoToUserEntity(registrationDTO);
        newUser.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));

        this.userRepository.save(newUser);
        login(newUser);
    }

    private void login(User user) {
        currentUser.
                setLoggedIn(true).
                setName(user.getUsername()).
                setEmail(user.getEmail());
    }

    public boolean login(LoginDTO loginDTO) {
        Optional<User> user = this.userRepository
                .findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());

        if (user.isEmpty()) {
            return false;
        }

        this.currentUser.setLoggedIn(true);

        return true;
    }

    public void logout() {
        currentUser.clear();
    }

    public boolean isLoggedIn() {
        return currentUser.isLoggedIn();
    }
}
