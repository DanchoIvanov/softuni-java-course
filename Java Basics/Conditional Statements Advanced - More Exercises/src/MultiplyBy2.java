import java.util.Scanner;

public class MultiplyBy2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double value = Double.parseDouble(scanner.nextLine());
        double result = 0;

        while (value >= 0){
            result = value*2;
            System.out.printf("Result: %.2f%n",result);
            value = Double.parseDouble(scanner.nextLine());

            if (value < 0){
                System.out.println("Negative number!");
                break;
            }
        }
    }
}
