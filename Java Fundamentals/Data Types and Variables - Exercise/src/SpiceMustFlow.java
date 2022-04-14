import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int yield = Integer.parseInt(scanner.nextLine());
        int minedAmount = 0;
        int days = 0;
        while (yield >= 100){
            minedAmount += yield -26;
            yield-=10;
            days++;
        }
        if (minedAmount >= 26){
            minedAmount -=26;
        }
        System.out.println(days);
        System.out.println(minedAmount);
    }
}
