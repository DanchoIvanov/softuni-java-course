package pizza_calories;

public enum BakingTechnique {

    CRISPY (0.9),
    CHEWY (1.1),
    HOMEMADE(1);

    private double modifier;

    BakingTechnique(double modifier) {
        this.modifier = modifier;
    }

    public double getModifier() {
        return this.modifier;
    }

    public static BakingTechnique getFromString(String topping) {
        switch (topping) {
            case "Crispy":
            case "Chewy":
            case "Homemade":
                return BakingTechnique.valueOf(topping.toUpperCase());
            default:
                throw new IllegalArgumentException("Invalid type of dough.");
        }
    }
}
