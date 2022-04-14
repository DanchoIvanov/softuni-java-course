import java.util.*;

public class PastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] liquids = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] ingredients = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Deque<Integer> liquidsQueue = new ArrayDeque<>();
        Arrays.stream(liquids).forEach(liquidsQueue::offer);
        Deque<Integer> ingredientsStack = new ArrayDeque<>();
        Arrays.stream(ingredients).forEach(ingredientsStack::push);

        Map<Integer, String> foodRecipes = new HashMap<>();
        foodRecipes.put(25, "Biscuit");
        foodRecipes.put(50, "Cake");
        foodRecipes.put(75, "Pastry");
        foodRecipes.put(100, "Pie");

        Map <String, Integer> productsMade = new LinkedHashMap<>();
        productsMade.put("Biscuit", 0);
        productsMade.put("Cake", 0);
        productsMade.put("Pie", 0);
        productsMade.put("Pastry", 0);

        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()){
            int currentLiquid = liquidsQueue.poll();;
            int currentIngredient = ingredientsStack.pop();
            int sum = currentLiquid + currentIngredient;
            if (foodRecipes.containsKey(sum)){
                String product = foodRecipes.get(sum);
                productsMade.put(product, productsMade.get(product) + 1);
            } else {
                ingredientsStack.push(currentIngredient + 3);
            }
        }

        if (!allMade(productsMade)) {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        } else {
            System.out.println("Great! You succeeded in cooking all the food!");
        }

        System.out.printf("Liquids left: %s%n", liquidsQueue.isEmpty() ? "none" : String.join(", ", liquidsQueue.toString().replaceAll("[\\[\\]]", "")));
        System.out.printf("Ingredients left: %s%n", ingredientsStack.isEmpty() ? "none" :  ingredientsStack.toString().replaceAll("[\\[\\]]", ""));

        productsMade.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
    }

    private static boolean allMade(Map<String, Integer> productsMade){
        for (Integer value : productsMade.values()) {
            if (value < 1){
                return false;
            }
        }
        return true;
    }
}
