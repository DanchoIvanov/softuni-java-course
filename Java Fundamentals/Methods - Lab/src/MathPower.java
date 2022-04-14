import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double n = Double.parseDouble(scanner.nextLine());
        int pow = Integer.parseInt(scanner.nextLine());

        System.out.println(new DecimalFormat("0.####").format(mathPower(n,pow)));

    }

    public static double mathPower(double number, int power){
        double result = number;
        for (int i = 1; i < power ; i++) {
            result*=number;
        }
        return result;
    }
}
