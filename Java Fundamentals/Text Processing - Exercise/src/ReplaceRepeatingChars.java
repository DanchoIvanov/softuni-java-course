import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder result = new StringBuilder(String.valueOf(input.charAt(0)));
        for (int i = 1; i <input.length() ; i++) {
            if (input.charAt(i) != input.charAt(i-1)){
                result.append(input.charAt(i));
            }
        }
        System.out.println(result);
    }
}
