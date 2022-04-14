package vehicles;

public class Bus extends Vehicle {

    private static final double ADDITIONAL_FUEL_CONSUMPTION = 1.4;
    private boolean isEmpty;

    protected Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption,tankCapacity);
        this.isEmpty = true;
    }

    public void setEmpty(boolean empty) {
        if (this.isEmpty && !empty){
            this.isEmpty = false;
            this.setFuelConsumption(this.getFuelConsumption() + ADDITIONAL_FUEL_CONSUMPTION);
        } else if (!this.isEmpty && empty){
            this.isEmpty = true;
            this.setFuelConsumption(this.getFuelConsumption() - ADDITIONAL_FUEL_CONSUMPTION);
        }
    }
}
