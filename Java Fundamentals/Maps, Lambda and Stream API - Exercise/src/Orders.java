import java.util.*;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, List<Double>> products = new LinkedHashMap<>();
        while(!input.equals("buy")){
            String product = input.split("\\s+")[0];
            double price = Double.parseDouble(input.split("\\s+")[1]);
            double quantity = Double.parseDouble(input.split("\\s+")[2]);
            if (!products.containsKey(product)){
                products.put(product, new ArrayList<>());
                products.get(product).add(price);
                products.get(product).add(quantity);
            } else {
                products.get(product).set(0,price);
                products.get(product).set(1, products.get(product).get(1) + quantity);
            }
            input = scanner.nextLine();
        }
        for (Map.Entry <String, List<Double>> entry : products.entrySet()){
            System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue().get(0)*entry.getValue().get(1));
        }
    }
}
