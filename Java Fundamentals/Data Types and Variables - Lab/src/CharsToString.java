import java.util.Scanner;

public class CharsToString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String result = "";

        for (int i = 1; i <=3 ; i++) {
            String input = scanner.nextLine();
            result += input;
        }
        System.out.println(result);
    }
}
