import java.util.Scanner;

public class LeftAndRightSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine())*2;
        int sumLeft = 0;
        int sumRight =0;

        for (int i = 1; i <=n ; i++) {
            int value = Integer.parseInt(scanner.nextLine());
            if (i<=n/2){
                sumLeft = sumLeft + value;
            }
            else
                sumRight = sumRight + value;
        }

        int difference = Math.abs(sumLeft-sumRight);

        if (sumLeft == sumRight){
            System.out.printf("Yes, sum = %d",sumLeft);
        }
        else
            System.out.printf("No, diff = %d",difference);
    }
}
