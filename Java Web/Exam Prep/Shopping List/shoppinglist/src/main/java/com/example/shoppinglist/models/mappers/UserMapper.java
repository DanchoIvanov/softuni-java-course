package com.example.shoppinglist.models.mappers;

import com.example.shoppinglist.models.User;
import com.example.shoppinglist.models.dto.RegistrationDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User userDtoToUserEntity(RegistrationDTO registrationDTO);
}