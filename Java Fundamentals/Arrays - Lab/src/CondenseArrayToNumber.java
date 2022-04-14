import java.util.Arrays;
import java.util.Scanner;

public class CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
        int [] condensed = new int[numbers.length -1];
        while (numbers.length >1){
            condensed = new int[numbers.length -1];
            for (int i = 0; i < numbers.length- 1; i++) {
                condensed [i] = numbers[i] + numbers[i+1];
            }
            numbers = new int[condensed.length];
            numbers = condensed;
        }
        System.out.println(numbers[0]);
    }
}
