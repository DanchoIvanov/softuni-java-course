package need_for_speed;

public class Main {
    public static void main(String[] args) {

        Vehicle vehicle = new Vehicle(1, 1);
        Car car = new Car(1, 1);
        Motorcycle motorcycle = new Motorcycle(1, 1);
        RaceMotorcycle raceMotorcycle = new RaceMotorcycle(1,1);
        CrossMotorcycle crossMotorcycle = new CrossMotorcycle(1, 1);
        FamilyCar familyCar = new FamilyCar(1, 1);
        SportCar sportCar = new SportCar(1, 1);

        System.out.println(vehicle.getFuelConsumption());
        System.out.println(car.getFuelConsumption());
        System.out.println(motorcycle.getFuelConsumption());
        System.out.println(raceMotorcycle.getFuelConsumption());
        System.out.println(crossMotorcycle.getFuelConsumption());
        System.out.println(familyCar.getFuelConsumption());
        System.out.println(sportCar.getFuelConsumption());
    }
}
