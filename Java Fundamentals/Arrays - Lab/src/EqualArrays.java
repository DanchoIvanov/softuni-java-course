import java.util.Arrays;
import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isNotEqual = false;

        int[] numbers1 = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        int[] numbers2 = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        for (int i = 0; i < numbers1.length ; i++) {
            if (numbers1[i] != numbers2[i]){
                isNotEqual = true;
                System.out.printf("Arrays are not identical. Found difference at %d index.",i);
                break;
            }
        }
        int sum = 0;
        if (isNotEqual == false) {
            for (int i = 0; i < numbers1.length; i++) {
                sum += numbers1[i];
            }
            System.out.printf("Arrays are identical. Sum: %d",sum);;
        }
    }
}
