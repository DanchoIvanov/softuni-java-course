import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] banWords = scanner.nextLine().split(", ");
        String input = scanner.nextLine();
        for (String word : banWords){
            StringBuilder replacement = new StringBuilder();
            replacement.append("*".repeat(word.length()));
            while (input.contains(word)){
                input = input.replace(word, replacement);
            }
        }
        System.out.println(input);
    }
}
