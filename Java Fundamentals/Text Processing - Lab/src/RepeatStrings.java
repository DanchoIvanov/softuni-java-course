import java.util.Scanner;

public class RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");

        StringBuilder result = new StringBuilder();
        for (String word : words){
            int n = word.length();
            result.append(word.repeat(n));
        }
        System.out.println(result);
    }
}
