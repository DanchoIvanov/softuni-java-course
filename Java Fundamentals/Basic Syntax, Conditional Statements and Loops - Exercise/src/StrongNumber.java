import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int originalNumber = number;
        int sum = 0;

        while(number !=0){
            int num = number % 10;
            number /= 10;
            int factorial = 1;
            for (int i = 1; i <= num; i++) {
                factorial *= i;
            }
            sum += factorial;
        }

        System.out.println(sum==originalNumber? ("yes") : ("no"));
    }
}
