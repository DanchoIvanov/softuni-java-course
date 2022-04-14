import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        int n = Integer.parseInt(scanner.nextLine());

        int[] numbersRotated = new int[numbers.length];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (j-1 < 0){
                    numbersRotated[numbers.length-1] = numbers[0];
                } else {
                    numbersRotated[j-1] = numbers[j];
                }
            }
            numbers = numbersRotated;
            numbersRotated = new int[numbers.length];
        }
        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("%d ",numbers[i]);
        }
    }
}
