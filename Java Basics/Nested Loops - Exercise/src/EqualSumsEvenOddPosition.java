import java.util.Scanner;

public class EqualSumsEvenOddPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());

        for (int i = firstNum; i <=secondNum ; i++) {
            String currentValue = String.valueOf(i);
            int evenSum = 0;
            int oddSum = 0;
            for (int j = 0; j < currentValue.length(); j++) {
                String currentChar = String.valueOf(currentValue.charAt(j));
                int currentNum = Integer.parseInt(currentChar);
                if ((j+1)%2 == 0){
                    evenSum += currentNum;
                }
                else if ((j+1)%2 == 1){
                    oddSum += currentNum;
                }
            }
            if (oddSum == evenSum){
                System.out.printf("%s ",currentValue);
            }
        }
    }
}
