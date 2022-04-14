import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while(!input.equals("END")){
            int num = Integer.parseInt(input);
            System.out.println(isPalindrome(num));
            input = scanner.nextLine();
        }
    }

    public static boolean isPalindrome (int n){
        String reversedNum = "";
        for (int i = String.valueOf(n).length()-1; i >=0 ; i--) {
            reversedNum += String.valueOf(n).charAt(i);
        }
        if (reversedNum.equals(String.valueOf(n))){
            return true;
        } else {
            return false;
        }
    }
}
