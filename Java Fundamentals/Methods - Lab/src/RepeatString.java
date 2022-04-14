import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int n  = Integer.parseInt(scanner.nextLine());

        System.out.println(repeatString(input,n));
    }

    public static String repeatString(String input, int n){
        String result = "";
        for (int i = 0; i < n; i++) {
            result += input;
        }
        return result;
    }
}
