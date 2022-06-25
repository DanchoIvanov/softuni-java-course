package com.example.shoppinglist.models.dto;

import com.example.shoppinglist.validations.FieldMatch;
import com.example.shoppinglist.validations.UniqueUsername;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@FieldMatch(firstField = "password",
        secondField = "confirmPassword",
        message = "Passwords do not match")
public class RegistrationDTO {

    @NotBlank(message = "Username must be between 3 and 20 characters!")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters!")
    @UniqueUsername(message = "Username already exists!")
    private String username;

    @NotBlank(message = "Email cannot be empty!")
    @Email
    private String email;

    @NotBlank(message = "Password must be between 3 and 20 characters!")
    @Size(min = 3, max = 20, message = "Password must be between 3 and 20 characters!")
    private String password;

    private String confirmPassword;

    public RegistrationDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
