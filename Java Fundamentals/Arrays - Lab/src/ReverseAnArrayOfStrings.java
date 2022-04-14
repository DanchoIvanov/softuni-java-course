import java.util.Scanner;

public class ReverseAnArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        for (int i = 0; i <=input.length - 1 ; i++) {
            System.out.printf("%s ",input[input.length - 1 -i]);
        }
    }
}
