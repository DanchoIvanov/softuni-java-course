import java.util.Scanner;

public class Login {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String userName = scanner.nextLine();
        String password = "";

        for (int i = userName.length()-1; i >= 0; i--) {
            password += userName.charAt(i);
        }


        String pass = scanner.nextLine();
        int logInFailsCount = 0;

        while (!pass.equals(password)){
            logInFailsCount ++;
            if (logInFailsCount == 4){
                System.out.println("User " + userName + " blocked!");
                return;
            }
            System.out.println("Incorrect password. Try again.");
            pass = scanner.nextLine();
        }
        System.out.println("User " + userName + " logged in.");
    }
}
