package com.example.spotifyplaylist.services;

import com.example.spotifyplaylist.models.User;
import com.example.spotifyplaylist.models.dtos.LoginDTO;
import com.example.spotifyplaylist.models.dtos.UserRegistrationDTO;
import com.example.spotifyplaylist.models.mappers.UserMapper;
import com.example.spotifyplaylist.repositories.UserRepository;
import com.example.spotifyplaylist.session.LoggedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final LoggedUser userSession;
    private final UserMapper userMapper;

    @Autowired
    public AuthenticationService(UserRepository userRepository, LoggedUser userSession, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userSession = userSession;
        this.userMapper = userMapper;
    }

    public boolean register(UserRegistrationDTO userRegistrationDTO) {
        if (!userRegistrationDTO.getPassword().equals(userRegistrationDTO.getConfirmPassword())) {
            return false;
        }

        Optional<User> byEmail = this.userRepository.findByEmail(userRegistrationDTO.getEmail());
        if (byEmail.isPresent()) {
            return false;
        }

        Optional<User> byUsername = this.userRepository.findByUsername(userRegistrationDTO.getUsername());
        if (byUsername.isPresent()) {
            return false;
        }

        User user = userMapper.userDtoToUserEntity(userRegistrationDTO);

        this.userRepository.save(user);

        return true;
    }

    public boolean login(LoginDTO loginDTO) {
        Optional<User> user = this.userRepository
                .findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());

        if (user.isEmpty()) {
            return false;
        }

        this.userSession.login(user.get());

        return true;
    }

    public void logout() {
        this.userSession.logout();
    }

    public boolean isLoggedIn() {
        return this.userSession.getId() > 0;
    }

    public long getLoggedUserId() {
        return this.userSession.getId();
    }
}