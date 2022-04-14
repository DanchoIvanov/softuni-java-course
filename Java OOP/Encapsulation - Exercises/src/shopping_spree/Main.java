package shopping_spree;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] peopleAsString = scanner.nextLine().split(";");
        String[] productsAsString = scanner.nextLine().split(";");

        Map<String, Person> people = new LinkedHashMap<>();
        Map<String, Product> products = new HashMap<>();

        for (String currentPerson : peopleAsString){
            String name = currentPerson.split("=")[0];
            double money = Double.parseDouble(currentPerson.split("=")[1]);
            try {
                Person person = new Person(name, money);
                people.put(name, person);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                return;
            }
        }

        for (String currentProduct : productsAsString){
            String name = currentProduct.split("=")[0];
            double cost = Double.parseDouble(currentProduct.split("=")[1]);
            try {
                Product product = new Product(name, cost);
                products.put(name, product);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                return;
            }
        }

        String input = scanner.nextLine();

        while (!input.equals("END")){
            String personName = input.split("\\s+")[0];
            String product = input.split("\\s+")[1];
            try {
                Person person = people.get(personName);
                Product currentProduct = products.get(product);
                person.buyProduct(currentProduct);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
            input = scanner.nextLine();
        }

        people.values().forEach(System.out::println);

    }
}
