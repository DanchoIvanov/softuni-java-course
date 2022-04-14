import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TakeSkipRope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Integer> numbers = new ArrayList<Integer>();
        List<Character> nonNumbers = new ArrayList<Character>();
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if  (Character.isDigit(symbol)){
                numbers.add(Integer.parseInt(Character.toString(symbol)));
            } else {
                nonNumbers.add(symbol);
            }
        }
        List<Integer> take = new ArrayList<Integer>();
        List<Integer> skip = new ArrayList<Integer>();

        for (int i = 0; i < numbers.size(); i++) {
            if (i % 2 == 0){
                take.add(numbers.get(i));
            } else {
                skip.add(numbers.get(i));
            }
        }
        int currentPosition = 0;
        String output = "";
        for (int i = 0; i < take.size(); i++) {
            int takeChars = take.get(i) + currentPosition;
            if (takeChars >= nonNumbers.size()){
                takeChars = nonNumbers.size();
            }
            for (int j = currentPosition; j < takeChars; j++) {
                output += nonNumbers.get(j);
            }
            int skipChars = skip.get(i);
            currentPosition = takeChars + skipChars;
        }
        System.out.println(output);
    }
}
