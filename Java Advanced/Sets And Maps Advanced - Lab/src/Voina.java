import java.util.*;
import java.util.stream.Collectors;

public class Voina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstPlayerDeck = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        Set<Integer> secondPlayerDeck = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        int rounds = 1;
        while (rounds <= 50 && !firstPlayerDeck.isEmpty() && !secondPlayerDeck.isEmpty()){
            int firstNumber = firstPlayerDeck.iterator().next();
            firstPlayerDeck.remove(firstNumber);
            int secondNumber = secondPlayerDeck.iterator().next();
            secondPlayerDeck.remove(secondNumber);

            if (firstNumber > secondNumber){
                firstPlayerDeck.add(firstNumber);
                firstPlayerDeck.add(secondNumber);
            } else if (secondNumber > firstNumber){
                secondPlayerDeck.add(firstNumber);
                secondPlayerDeck.add(secondNumber);
            }

            rounds++;
        }

        if (firstPlayerDeck.size() > secondPlayerDeck.size()){
            System.out.println("First player win!");
        } else if (secondPlayerDeck.size() > firstPlayerDeck.size()){
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
