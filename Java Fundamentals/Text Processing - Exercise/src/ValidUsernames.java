import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] usernames = scanner.nextLine().split(", ");
        for (String user : usernames){
            if (isRightLength(user) && containsOnlyLegalCharacters(user)){
                System.out.println(user);
            }
        }
    }

    private static boolean isRightLength(String user){
        return user.length() >= 3 && user.length() <= 16;
    }

    private static boolean containsOnlyLegalCharacters(String user){
        for (int i = 0; i < user.length(); i++) {
            if (!Character.isLetterOrDigit(user.charAt(i)) && user.charAt(i) != '-' && user.charAt(i) != '_'){
                return false;
            }
        }
        return true;
    }
}
