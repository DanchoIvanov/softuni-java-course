package com.example.xml_ex.cardealer.entities.sale;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SaleDiscount {
    private List<Double> discounts;

    public SaleDiscount() {
        fillDiscounts();
    }

    private void fillDiscounts() {
        discounts = new ArrayList<>();

        discounts.add(1.0);
        discounts.add(0.95);
        discounts.add(0.90);
        discounts.add(0.85);
        discounts.add(0.80);
        discounts.add(0.70);
        discounts.add(0.60);
        discounts.add(0.50);
    }

    public double getRandomDiscount() {
        int size = discounts.size();

        int randomIndex = new Random().nextInt(size);

        return discounts.get(randomIndex);

    }


}
