package com.example.demo.entities;

public enum AgeRestriction {

    MINOR("Minor"),
    TEEN("Teen"),
    ADULT("Adult");

    private String value;

    AgeRestriction(String value) {
        this.value = value;
    }
}
