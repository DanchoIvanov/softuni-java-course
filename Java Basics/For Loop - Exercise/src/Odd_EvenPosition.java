import java.util.Scanner;

public class Odd_EvenPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double evenMax = -Double.MAX_VALUE;
        double oddMax = -Double.MAX_VALUE;
        double evenMin = Double.MAX_VALUE;
        double oddMin = Double.MAX_VALUE;
        double evenSum = 0;
        double oddSum = 0;

        for (int i = 1; i <=n; i++) {
            double value = Double.parseDouble(scanner.nextLine());
            if (i % 2 == 0){
                evenSum = evenSum + value;
                if (value > evenMax){
                    evenMax = value;
                }
                if (value < evenMin){
                    evenMin = value;
                }
            }
            else {
                oddSum = oddSum + value;
                if (value > oddMax){
                    oddMax = value;
                }
                if (value < oddMin){
                    oddMin = value;
                }
            }
        }
        System.out.printf("OddSum=%.2f,%n",oddSum);
        if (n == 0){
            System.out.printf("OddMin=No,%n");
            System.out.printf("OddMax=No,%n");
        }
        else {
            System.out.printf("OddMin=%.2f,%n", oddMin);
            System.out.printf("OddMax=%.2f,%n", oddMax);
        }
        System.out.printf("EvenSum=%.2f,%n",evenSum);
        if (n == 0 || n == 1){
            System.out.printf("EvenMin=No,%n");
            System.out.printf("EvenMax=No%n");
        }
        else {
            System.out.printf("EvenMin=%.2f,%n", evenMin);
            System.out.printf("EvenMax=%.2f%n", evenMax);
        }
    }
}
