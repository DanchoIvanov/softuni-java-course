package pizza_calories;

public enum FlourType {

    WHITE (1.5),
    WHOLEGRAIN (1);

    private double modifier;

    FlourType(double modifier) {
        this.modifier = modifier;
    }

    public double getModifier() {
        return this.modifier;
    }

    public static FlourType getFromString(String topping) {
        switch (topping) {
            case "White":
            case "Wholegrain":
                return FlourType.valueOf(topping.toUpperCase());
            default:
                throw new IllegalArgumentException("Invalid type of dough.");
        }
    }
}
