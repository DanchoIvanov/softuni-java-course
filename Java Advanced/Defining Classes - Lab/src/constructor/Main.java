package constructor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            Car car = new Car(input[0]);

            if (input.length == 3){
                car = new Car (input[0], input[1], Integer.parseInt(input[2]));
            } else if (input.length == 2){
                try {
                    int horsepower = Integer.parseInt(input[1]);
                    car = new Car(input[0], horsepower);
                }
                catch (NumberFormatException e){
                    String model = input[0];
                    car = new Car(input[0], model);
                }
            }

            System.out.println(car);
        }
    }
}
