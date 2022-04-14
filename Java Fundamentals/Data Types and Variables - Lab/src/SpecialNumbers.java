import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n ; i++) {
            int sum = 0;
            int m = i;
            while (m != 0){
                int num = m % 10;
                sum += num;
                m/=10;
            }
            System.out.printf((sum==5||sum==7||sum==11)? (i + " -> True%n") : ((i + " -> False%n")));
        }
    }
}
