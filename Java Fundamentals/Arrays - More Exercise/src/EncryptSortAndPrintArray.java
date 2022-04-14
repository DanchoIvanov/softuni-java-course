import java.util.Arrays;
import java.util.Scanner;

public class EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            int sum=0;
            for (int j = 0; j < input.length(); j++) {
                char currentChar = input.charAt(j);
                switch (Character.toLowerCase(currentChar)){
                    case 'a':
                    case 'e':
                    case 'o':
                    case 'i':
                    case 'u':
                        sum += currentChar*input.length();
                        break;
                    default:
                        sum += currentChar/input.length();
                        break;
                }
            }
            numbers[i] = sum;
        }
        Arrays.sort(numbers);
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
