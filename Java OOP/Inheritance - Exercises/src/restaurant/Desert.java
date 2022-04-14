package restaurant;

import java.math.BigDecimal;

public class Desert extends Food {

    private double calories;

    public Desert(String name, BigDecimal price, double grams, double calories) {
        super(name, price, grams);
        this.calories = calories;
    }

    public double getCalories() {
        return calories;
    }
}
