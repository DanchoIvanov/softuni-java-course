import java.util.Scanner;

public class FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            long num1 = Long.parseLong(input.split(" ")[0]);
            long num2 = Long.parseLong(input.split(" ")[1]);
            long maxNum = Math.max(num1, num2);
            int digitsSum = 0;
            while (maxNum !=0) {
                long lastDigit = Math.abs(maxNum) % 10;
                digitsSum += lastDigit;
                maxNum/=10;
            }
            System.out.println(digitsSum);
        }
    }
}
