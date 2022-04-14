package car_salesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Engine> engines = new HashMap<>();
        List<Car> cars = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            int horsePower = Integer.parseInt(input[1]);
            Engine engine = new Engine(model, horsePower);

            if (input.length == 3){
                try {
                    int displacement = Integer.parseInt(input[2]);
                    engine = new Engine(model, horsePower, displacement);
                }
                catch (NumberFormatException e){
                    String efficiency = input[2];
                    engine = new Engine(model, horsePower, efficiency);
                }
            } else if (input.length == 4){
                int displacement = Integer.parseInt(input[2]);
                String efficiency = input[3];
                engine = new Engine(model, horsePower, displacement, efficiency);
            }
            engines.put(model, engine);
        }

        int m = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < m; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            String engine = input[1];
            Car car = new Car(model, engine);

            if (input.length == 3){
                try {
                    int weight = Integer.parseInt(input[2]);
                    car = new Car(model, engine, weight);
                }
                catch (NumberFormatException e){
                    String color = input[2];
                    car = new Car(model, engine, color);
                }
            } else if (input.length == 4){
                int weight = Integer.parseInt(input[2]);
                String color = input[3];
                car = new Car(model, engine, weight, color);
            }
            cars.add(car);
        }
        cars.forEach(e->{
            System.out.printf("%s:%n",e.getModel());
            System.out.printf("%s:%n",e.getEngine());
            System.out.printf("Power: %d%n", engines.get(e.getEngine()).getHorsePower());
            if (engines.get(e.getEngine()).getDisplacement()==0){
                System.out.println("Displacement: n/a");
            } else {
                System.out.printf("Displacement: %d%n",engines.get(e.getEngine()).getDisplacement());
            }
            System.out.printf("Efficiency: %s%n",engines.get(e.getEngine()).getEfficiency());
            if (e.getWeight() == 0){
                System.out.println("Weight: n/a");
            } else {
                System.out.printf("Weight: %d%n", e.getWeight());
            }
            System.out.printf("Color: %s%n",e.getColor());
        });
    }
}
