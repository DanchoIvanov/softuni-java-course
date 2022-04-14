package restaurant.entities.healthyFoods;

import restaurant.entities.healthyFoods.interfaces.HealthyFood;

public class VeganBiscuits extends Food {

    private static final double INITIAL_VEGAN_BISCUIT_PORTION = 205;

    public VeganBiscuits(String name, double price) {
        super(name, INITIAL_VEGAN_BISCUIT_PORTION, price);
    }
}
