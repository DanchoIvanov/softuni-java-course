import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String>  emailAddressBook = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while(!input.equals("stop")){
            String name = input;
            String email = scanner.nextLine();
            if (!email.toLowerCase().endsWith("us") && !email.toLowerCase().endsWith("uk") && !email.toLowerCase().endsWith("com")){
                emailAddressBook.put(name, email);
            }
            input = scanner.nextLine();
        }
        emailAddressBook.forEach((k,v)-> System.out.printf("%s -> %s%n",k,v));
    }
}
