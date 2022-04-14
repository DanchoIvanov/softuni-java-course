import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> hand1 = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> hand2 = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while(!hand1.isEmpty() && !hand2.isEmpty()){
            if (hand1.get(0) > hand2.get(0)){
                hand1.add(hand1.get(0));
                hand1.remove(0);
                hand1.add(hand2.get(0));
                hand2.remove(0);
            } else if (hand1.get(0).equals(hand2.get(0))){
                hand1.remove(0);
                hand2.remove(0);
            } else {
                hand2.add(hand2.get(0));
                hand2.remove(0);
                hand2.add(hand1.get(0));
                hand1.remove(0);
            }
        }
        int sum = 0;
        String winner = "";
        if (hand1.isEmpty()){
            winner = "Second";
            for (int element:hand2) {
                sum += element;
            }
        } else {
            winner = "First";
            for (int element:hand1) {
                sum += element;
            }
        }
        System.out.printf("%s player wins! Sum: %d",winner, sum);
    }
}
