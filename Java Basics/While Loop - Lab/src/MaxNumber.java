import java.util.Scanner;

public class MaxNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxValue = Integer.MIN_VALUE;
        String input = scanner.nextLine();

        while (!input.equals("Stop")){
            int value = Integer.parseInt(input);
            if (value > maxValue){
                maxValue = value;
            }
            input = scanner.nextLine();
        }
        System.out.println(maxValue);
    }
}
