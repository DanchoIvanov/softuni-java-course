import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e-> Integer.parseInt(e))
                .toArray();

        for (int i = 0; i < numbers.length; i++) {
            boolean isBigger = true;
            for (int j = i; j < numbers.length-1; j++) {
                if (numbers[i] <= numbers[j+1]){
                    isBigger = false;
                }
            }
            if (isBigger){
                System.out.printf("%d ", numbers[i]);
            }
        }
    }
}
