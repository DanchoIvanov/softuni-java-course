package cat_lady;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Cat> cats = new HashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("End")){
            String breed = input.split("\\s+")[0];
            String name = input.split("\\s+")[1];
            double characteristic = Double.parseDouble(input.split("\\s+")[2]);
            cats.put(name, new Cat(breed, name, characteristic));
            input = scanner.nextLine();
        }
        String name = scanner.nextLine();
        System.out.println(cats.get(name));
    }
}
