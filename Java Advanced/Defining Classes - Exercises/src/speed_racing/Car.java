package speed_racing;

public class Car {

    private String model;
    private double fuelAmount;
    private double fuelCostFor1km;
    private int distance;

    public Car(String model, double fuelAmount, double fuelCostFor1km) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostFor1km = fuelCostFor1km;
        this.distance = 0;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public int getDistance() {
        return distance;
    }

    public boolean drive(int distance) {
        if (distance * this.fuelCostFor1km > this.fuelAmount){
            return false;
        } else {
            this.distance += distance;
            this.fuelAmount -= distance * this.fuelCostFor1km;
            return true;
        }
    }
}
