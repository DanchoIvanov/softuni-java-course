package com.example.demo.entities;

public enum EditionType {

    NORMAL("Normal"),
    PROMO("Promo"),
    GOLD("Gold");

    private String value;

    EditionType(String value) {
        this.value = value;
    }
}
