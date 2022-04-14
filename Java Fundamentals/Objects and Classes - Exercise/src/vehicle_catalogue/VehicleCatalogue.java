package vehicle_catalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleCatalogue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Vehicle> vehicles = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String type = input.split(" ")[0];
            if (type.equalsIgnoreCase("car")){
                type = "Car";
            } else {
                type = "Truck";
            }
            String model = input.split(" ")[1];
            String color = input.split(" ")[2];
            int horsepower = Integer.parseInt(input.split(" ")[3]);
            Vehicle vehicle = new Vehicle(type, model, color, horsepower);
            vehicles.add(vehicle);
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("Close the Catalogue")) {
            if (vehicleExists(vehicles, input)) {
                Vehicle vehicle = getVehicle(vehicles, input);
                assert vehicle != null;
                System.out.printf("Type: %s%n", vehicle.type);
                System.out.printf("Model: %s%n", vehicle.model);
                System.out.printf("Color: %s%n", vehicle.color);
                System.out.printf("Horsepower: %d%n", vehicle.horsepower);
            }
            input = scanner.nextLine();
        }
        double averageHorsepowerCars = getAverageHorsepower(vehicles, "Car");
        double averageHorsepowerTrucks = getAverageHorsepower(vehicles, "Truck");
        System.out.printf("Cars have average horsepower of: %.2f.%n",averageHorsepowerCars);
        System.out.printf("Trucks have average horsepower of: %.2f.%n",averageHorsepowerTrucks);
    }


    private static double getAverageHorsepower(List<Vehicle> vehicles, String type) {
        double averageHorsepower =0;
        int vehiclesMatchingType = 0;
        for (Vehicle vehicle : vehicles){
            if (vehicle.getType().equals(type)){
                averageHorsepower += vehicle.getHorsepower();
                vehiclesMatchingType++;
            }
        }
        if (vehiclesMatchingType > 0){
            averageHorsepower = averageHorsepower/vehiclesMatchingType;
        }
        return averageHorsepower;
    }

    private static Vehicle getVehicle(List<Vehicle> vehicles, String input) {
        for (Vehicle vehicle: vehicles){
            if (vehicle.getModel().equals(input)){
                return vehicle;
            }
        }
        return null;
    }

    private static boolean vehicleExists(List<Vehicle> vehicles, String input) {
        for (Vehicle vehicle:vehicles){
            if (vehicle.getModel().equals(input)){
                return true;
            }
        }
        return false;
    }

    public static class Vehicle {

        private String type;
        private String model;
        private String color;
        private int horsepower;

        public Vehicle(String type, String model, String color, int horsepower) {
            this.type = type;
            this.model = model;
            this.color = color;
            this.horsepower = horsepower;
        }

        public String getColor() {
            return color;
        }

        public int getHorsepower() {
            return horsepower;
        }

        public String getModel() {
            return model;
        }

        public String getType() {
            return type;
        }
    }
}
