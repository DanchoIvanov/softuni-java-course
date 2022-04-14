package speed_racing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Car> cars = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            double fuelAmount = Double.parseDouble(input[1]);
            double fuelCostFor1km = Double.parseDouble(input[2]);
            Car car = new Car(model, fuelAmount, fuelCostFor1km);
            cars.put(model, car);
        }

        String input = scanner.nextLine();
        while (!input.equals("End")){
            String model = input.split("\\s+")[1];
            int distance = Integer.parseInt(input.split("\\s+")[2]);
            if (!cars.get(model).drive(distance)){
                System.out.println("Insufficient fuel for the drive");
            }
            input = scanner.nextLine();
        }

        cars.forEach((k,v) -> System.out.printf("%s %.2f %d%n",k, v.getFuelAmount(), v.getDistance()));
    }
}
