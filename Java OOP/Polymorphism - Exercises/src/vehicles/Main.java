package vehicles;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Vehicle> vehicles = new LinkedHashMap<>();

        String[] carInfo = scanner.nextLine().split("\\s+");
        String vehicleType = carInfo[0];
        double carFuelQuantity = Double.parseDouble(carInfo[1]);
        double carFuelConsumption = Double.parseDouble(carInfo[2]);
        double carTankCapacity = Double.parseDouble(carInfo[3]);
        Car car = new Car(carFuelQuantity, carFuelConsumption, carTankCapacity);
        vehicles.put(vehicleType, car);

        String[] truckInfo = scanner.nextLine().split("\\s+");
        vehicleType = truckInfo[0];
        double truckFuelQuantity = Double.parseDouble(truckInfo[1]);
        double truckFuelConsumption = Double.parseDouble(truckInfo[2]);
        double truckTankCapacity = Double.parseDouble(truckInfo[3]);
        Truck truck = new Truck(truckFuelQuantity, truckFuelConsumption, truckTankCapacity);
        vehicles.put(vehicleType, truck);

        String[] busInfo = scanner.nextLine().split("\\s+");
        vehicleType = busInfo[0];
        double busFuelQuantity = Double.parseDouble(busInfo[1]);
        double busFuelConsumption = Double.parseDouble(busInfo[2]);
        double busTankCapacity = Double.parseDouble(busInfo[3]);
        Bus bus = new Bus(busFuelQuantity, busFuelConsumption, busTankCapacity);
        vehicles.put(vehicleType, bus);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String command = input[0];
            String vehicle = input[1];
            switch (command){
                case "Drive":
                    double distance = Double.parseDouble(input[2]);
                    if (vehicle.equals("Bus")){
                        bus.setEmpty(false);
                    }
                    vehicles.get(vehicle).drive(distance);
                    break;
                case "Refuel":
                    double liters = Double.parseDouble(input[2]);
                    vehicles.get(vehicle).refuel(liters);
                    break;
                case "DriveEmpty":
                    distance = Double.parseDouble(input[2]);
                    bus.setEmpty(true);
                    bus.drive(distance);
            }
        }
        vehicles.forEach((key, value) -> System.out.printf("%s: %.2f%n", key, value.getFuelQuantity()));
    }
}
