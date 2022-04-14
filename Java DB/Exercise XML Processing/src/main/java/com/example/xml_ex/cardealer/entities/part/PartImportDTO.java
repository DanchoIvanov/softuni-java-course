package com.example.xml_ex.cardealer.entities.part;

import java.math.BigDecimal;

public class PartImportDTO {

    private String name;
    private BigDecimal price;
    private int quantity;

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
