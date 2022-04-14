package pizza_calories;

public enum ToppingType {

    MEAT(1.2),
    VEGGIES(0.8),
    CHEESE(1.1),
    SAUCE(0.9);

    private final double modifier;

    ToppingType(double modifier) {
        this.modifier = modifier;
    }

    public double getModifier() {
        return this.modifier;
    }

    public static ToppingType getFromString(String topping) {
        switch (topping) {
            case "Meat":
            case "Veggies":
            case "Cheese":
            case "Sauce":
                return ToppingType.valueOf(topping.toUpperCase());
            default:
                throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.",topping));
        }
    }
}
