import java.util.Scanner;

public class SignOfIntegerNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        System.out.println("The number " + n + isIntegerPositive(n));
    }

    private static String isIntegerPositive(int n) {
        if (n < 0){
            return " is negative.";
        } else if (n == 0){
            return " is zero.";
        } else {
            return " is positive.";
        }
    }
}
