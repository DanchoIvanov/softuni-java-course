import java.util.*;

public class AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] ingredients = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] fitnessLevel = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Deque<Integer> ingredientsQueue = new ArrayDeque<>();
        Arrays.stream(ingredients).forEach(ingredientsQueue::offer);

        Deque<Integer> fitnessLevelStack = new ArrayDeque<>();
        Arrays.stream(fitnessLevel).forEach(fitnessLevelStack::push);

        Map <Integer, String> cocktailRecipes = new HashMap<>();
        cocktailRecipes.put(150, "Pear Sour");
        cocktailRecipes.put(250, "The Harvest");
        cocktailRecipes.put(300, "Apple Hinny");
        cocktailRecipes.put(400, "High Fashion");

        Map <String, Integer> cocktailsMade = new TreeMap<>();

        while (!ingredientsQueue.isEmpty() && !fitnessLevelStack.isEmpty()){
            boolean ingredientsQueueIsEmpty = false;
            int currentIngredient = ingredientsQueue.poll();
            while (currentIngredient == 0) {
                if (!ingredientsQueue.isEmpty()) {
                    currentIngredient = ingredientsQueue.poll();
                } else {
                    ingredientsQueueIsEmpty = true;
                    break;
                }
            }
            if (ingredientsQueueIsEmpty){
                break;
            }
            int currentFitnessLevel = fitnessLevelStack.pop();
            int result = currentIngredient*currentFitnessLevel;
            if (cocktailRecipes.containsKey(result)){
                String currentCocktail = cocktailRecipes.get(result);
                cocktailsMade.putIfAbsent(currentCocktail, 0);
                cocktailsMade.put(currentCocktail, cocktailsMade.get(currentCocktail) + 1);
            } else {
                ingredientsQueue.offer(currentIngredient + 5);
            }

        }

        if(cocktailsMade.size() == 4){
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        if (!ingredientsQueue.isEmpty()){
            System.out.printf("Ingredients left: %d%n",ingredientsQueue.stream().mapToInt(e -> e).sum());
        }

        cocktailsMade.forEach((k, v) -> System.out.printf(" # %s --> %d%n", k, v));

    }
}
