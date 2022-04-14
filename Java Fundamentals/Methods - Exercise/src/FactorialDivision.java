import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        System.out.printf("%.2f", getFactorial(a)/getFactorial(b));
    }

    public static double getFactorial(int a){
        double result = 1;
        for (int i = 1; i <= a; i++) {
            result*=i;
        }
        return result;
    }
}
