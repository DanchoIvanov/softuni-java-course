package pizza_calories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            String[] pizzaAsString = scanner.nextLine().split("\\s+");
            String name = pizzaAsString[1];
            int numberOfToppings = Integer.parseInt(pizzaAsString[2]);
            Pizza pizza = new Pizza(name, numberOfToppings);

            String[] doughAsString = scanner.nextLine().split("\\s+");
            String doughType = doughAsString[1];
            String bakingTechnique = doughAsString[2];
            double doughWeight = Double.parseDouble(doughAsString[3]);
            Dough dough = new Dough(doughType, bakingTechnique, doughWeight);

            pizza.setDough(dough);

            String[] input = scanner.nextLine().split("\\s+");

            while (!input[0].equals("END")){
                String toppingType = input[1];
                double weight = Double.parseDouble(input[2]);
                Topping topping = new Topping(toppingType, weight);
                pizza.addTopping(topping);
                input = scanner.nextLine().split("\\s+");;
            }

            System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());

        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
