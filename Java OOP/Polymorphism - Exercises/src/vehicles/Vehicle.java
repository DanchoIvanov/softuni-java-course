package vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {

    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;
    DecimalFormat formatter = new DecimalFormat("##.##");

    protected Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
        this.setTankCapacity(tankCapacity);
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    private void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public void drive(double distance){
        if (distance * this.getFuelConsumption() > this.getFuelQuantity()){
            System.out.printf("%s needs refueling%n", this.getClass().getSimpleName());
        } else {
            System.out.printf("%s travelled %s km%n", this.getClass().getSimpleName(), formatter.format(distance));
            this.setFuelQuantity(this.getFuelQuantity() - distance * this.getFuelConsumption());
        }
    }


    public void refuel(double liters){
        if (liters <= 0) {
            System.out.println("Fuel must be a positive number");
        } else if (this.getFuelQuantity() + liters > tankCapacity){
            System.out.println("Cannot fit fuel in tank");
        } else {
            this.setFuelQuantity(this.getFuelQuantity() + liters);
        }
    }
}
