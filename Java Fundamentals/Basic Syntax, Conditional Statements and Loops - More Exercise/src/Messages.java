import java.util.Scanner;

public class Messages {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String message = "";

        for (int i = 1; i <=n ; i++) {
            String input = scanner.nextLine();
            int mainDigit = Integer.parseInt(String.valueOf(input.charAt(0)));
            int offset = (mainDigit - 2)*3;
            if (mainDigit == 8 || mainDigit == 9){
                offset+=1;
            }
            int letterIndex = offset + input.length() - 1;
            char currentChar = (char)(letterIndex + 97);
            if (currentChar == '['){
                currentChar = ' ';
            }
            message += currentChar;
        }
        System.out.println(message);
    }
}
