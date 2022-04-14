package raw_data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            int speed = Integer.parseInt(input[1]);
            int horsePower = Integer.parseInt(input[2]);
            int cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];
            double tire1Pressure = Double.parseDouble(input[5]);
            int tire1Age = Integer.parseInt(input[6]);
            double tire2Pressure = Double.parseDouble(input[7]);
            int tire2Age = Integer.parseInt(input[8]);
            double tire3Pressure = Double.parseDouble(input[9]);
            int tire3Age = Integer.parseInt(input[10]);
            double tire4Pressure = Double.parseDouble(input[11]);
            int tire4Age = Integer.parseInt(input[12]);
            Car car = new Car(model, new Engine(speed, horsePower), new Cargo(cargoWeight, cargoType), Arrays.asList(new Tire(tire1Pressure, tire1Age), new Tire(tire2Pressure, tire2Age), new Tire(tire3Pressure, tire3Age), new Tire(tire4Pressure, tire4Age)));
            cars.add(car);
        }

        String command = scanner.nextLine();
        switch (command){
            case "fragile":
                for (Car car : cars){
                   if (lowTirePressure(car) && car.getCargo().getType().equals("fragile")){
                       System.out.println(car.getModel());
                   }
                }
                break;
            case "flamable":
                for (Car car :cars){
                    if (car.getEngine().getHorsePower() > 250 && car.getCargo().getType().equals("flamable")){
                        System.out.println(car.getModel());
                    }
                }
                break;
        }

    }
    private static boolean lowTirePressure(Car car){
        for (Tire tire : car.getTires()){
            if (tire.getAirPressure() <1){
                return true;
            }
        }
        return false;
    }
}
