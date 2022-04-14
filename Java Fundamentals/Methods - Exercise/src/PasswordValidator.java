import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();
        isPasswordValid(password);
    }

    public static void isPasswordValid (String password){
        boolean isNotOk = false;
        if (isPaswordLongEnough(password) == false){
           System.out.println("Password must be between 6 and 10 characters");
            isNotOk = true;
       }
        if (isPasswordCharactersLegal(password) == false){
            System.out.println("Password must consist only of letters and digits");
            isNotOk = true;
        }
        if (contain2Digits(password) == false){
            System.out.println("Password must have at least 2 digits");
            isNotOk = true;
        }
        if(isNotOk == false) {
            System.out.println("Password is valid");
        }
    }

    static boolean isPaswordLongEnough(String password){
        if (password.length()>=6 && password.length() <=10){
            return true;
        } else {

            return false;
        }
    }

    static boolean isPasswordCharactersLegal (String password){
        for (int i = 0; i < password.length(); i++) {
            if (Character.isLetterOrDigit(password.charAt(i)) == false){
                return false;
            }
        }
        return true;
    }

    static boolean contain2Digits (String password){
        int digitsCount = 0;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))){
                digitsCount ++;
                if (digitsCount >= 2){
                    return true;
                }
            }
        }
        return false;
    }
}
