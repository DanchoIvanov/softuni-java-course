import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        int multiplier = Integer.parseInt(scanner.nextLine());
        StringBuilder result = new StringBuilder();
        int decimal = 0;
        for (int i = 0; i < number.length(); i++) {
            if (number.startsWith("0")){
                number = number.replace("0", "");
                i=-1;
            } else {
                break;
            }
        }
        if (multiplier >0 && !number.equals("")) {
            for (int i = number.length() - 1; i >= 0; i--) {
                int currentResult = Integer.parseInt(String.valueOf(number.charAt(i))) * multiplier + decimal;
                result.append(currentResult % 10);
                if (i != 0) {
                    decimal = currentResult / 10;
                } else if (currentResult / 10 != 0) {
                    result.append(currentResult / 10);
                }
            }

            System.out.println(result.reverse());
        } else {
            System.out.println(0);
        }
    }
}