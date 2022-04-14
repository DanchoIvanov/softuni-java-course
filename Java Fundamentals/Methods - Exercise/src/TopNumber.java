import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        getTopNumbers(n);
    }

    public static void getTopNumbers(int n){
        for (int i = 1; i <= n; i++) {
           if(isTopNumber(i)){
               System.out.println(i);
            }
        }
    }

    public static boolean isTopNumber(int num) {
        if (containsOddDigit(num)) {
            int sumOfDigits = 0;
            while (num != 0) {
                sumOfDigits += num % 10;
                num /= 10;
            }
            if (sumOfDigits % 8 == 0) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public static boolean containsOddDigit(int num){
        int currentNum;
        while (num != 0){
            currentNum = num%10;
            if (currentNum%2 ==1){
                return  true;
            }
            num/=10;
        }
        return  false;
    }
}
