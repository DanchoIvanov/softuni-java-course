package com.example.jsonex.cardealer.entities.customer;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CustomerImportDTO {
    private String name;
    private String birthDate;
    private boolean isYoungDriver;

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public boolean isYoungDriver() {
        return isYoungDriver;
    }
}
