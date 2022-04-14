import java.util.Scanner;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        boolean isBalanced = true;
        for (int i = 0; i <n ; i++) {
            String input = scanner.nextLine();
            if ((input.equals("(") || input.equals(")")) && isBalanced == true) {
                isBalanced = false;
            } else if ((input.equals("(") || input.equals(")")) && isBalanced == false){
                isBalanced = true;
            }
        }
        System.out.println(isBalanced? "BALANCED" : "UNBALANCED");
    }
}
