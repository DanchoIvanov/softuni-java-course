import java.util.Scanner;

public class MultiplyEvensByOdds {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        System.out.println(getMultipleOfEvensAndOdds(Math.abs(number)));

    }

    public static int getMultipleOfEvensAndOdds(int number){
        int evensSum = getEvenDigitsSum(number);
        int oddSum = getOddDigitsSum(number);

        return evensSum*oddSum;
    }


    public static int getEvenDigitsSum(int number) {
        int result = 0;
        while (number !=0){
            int currentDigit = number%10;
            if (currentDigit%2 == 0){
                result += currentDigit;
            }
            number/=10;
        }
        return result;
    }


    public static int getOddDigitsSum(int number) {
        int result = 0;
        while (number !=0){
            int currentDigit = number%10;
            if (currentDigit%2 == 1){
                result += currentDigit;
            }
            number/=10;
        }
        return result;
    }
}
