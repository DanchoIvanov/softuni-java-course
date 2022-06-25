package com.example.spotifyplaylist.models.mappers;

import com.example.spotifyplaylist.models.User;
import com.example.spotifyplaylist.models.dtos.UserRegistrationDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper {

    User userDtoToUserEntity(UserRegistrationDTO userRegistrationDTO);
}