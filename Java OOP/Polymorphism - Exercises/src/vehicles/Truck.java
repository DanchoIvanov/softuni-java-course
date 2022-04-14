package vehicles;

public class Truck extends Vehicle {

    private static final double ADDITIONAL_FUEL_CONSUMPTION = 1.6;
    private static final double REFUELING_EFFICIENCY = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, (fuelConsumption + ADDITIONAL_FUEL_CONSUMPTION), tankCapacity);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters * REFUELING_EFFICIENCY);
    }
}
