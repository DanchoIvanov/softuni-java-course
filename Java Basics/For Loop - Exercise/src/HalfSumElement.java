import java.util.Scanner;

public class HalfSumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int maxValue = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 1; i <=n ; i++) {
            int value = Integer.parseInt(scanner.nextLine());
            sum = sum + value;

            if (value > maxValue){
                maxValue = value;
            }
        }
        int difference = Math.abs(sum - 2*maxValue);

        if (difference == 0){
            System.out.printf("Yes\n" +
                    "Sum = %d",(sum - maxValue));
        }
        else
            System.out.printf("No\n" +
                    "Diff = %d",difference);

    }
}
