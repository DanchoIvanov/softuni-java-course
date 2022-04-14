package pizza_calories;

public class Topping {

    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        ToppingType currentTopping = ToppingType.getFromString(toppingType);
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if (weight < 0 || weight >50){
            throw new IllegalArgumentException (String.format("%s weight should be in the range [1..50].", this.toppingType));
        }
        this.weight = weight;
    }

    public double calculateCalories(){
        return ToppingType.getFromString(this.toppingType).getModifier() * this.weight * 2;
    }
}
