import java.util.Scanner;

public class DecryptingMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int interval = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        String result = "";
        for (int i = 0; i < n; i++) {
            char inputChar = scanner.nextLine().charAt(0);
            char decryptedChar = (char) (inputChar + interval);
            result += decryptedChar;
        }
        System.out.println(result);
    }
}
