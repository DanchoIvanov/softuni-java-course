package restaurant;

import java.math.BigDecimal;

public class Coffee extends HotBeverage {

    private double caffeine;
    private static final double COFFEE_MILLILITERS = 50.0D;
    private static final BigDecimal COFFEE_PRICE = BigDecimal.valueOf(3.5D);

    public Coffee(String name, double caffeine) {
        super(name, COFFEE_PRICE, COFFEE_MILLILITERS);
        this.caffeine = caffeine;
    }

    public double getCaffeine() {
        return this.caffeine;
    }
}
