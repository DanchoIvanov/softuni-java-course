import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        System.out.println(getMiddleChar(input));

    }

    public static String getMiddleChar(String input){
        if (input.length() % 2 == 1){
            return String.valueOf(input.charAt(input.length()/2));
        } else {
            return String.valueOf(input.charAt(input.length()/2-1)) + String.valueOf(input.charAt(input.length()/2));
        }
    }
}
