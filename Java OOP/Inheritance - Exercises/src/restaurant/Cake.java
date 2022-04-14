package restaurant;

import java.math.BigDecimal;

public class Cake extends Dessert {

    private static final double CAKE_GRAMS = 250.0D;
    private static final double CAKE_CALORIES = 1000.0D;
    private static final BigDecimal CAKE_PRICE = BigDecimal.valueOf(5L);


    public Cake(String name) {
        super(name, CAKE_PRICE, CAKE_GRAMS, CAKE_CALORIES);
    }
}
