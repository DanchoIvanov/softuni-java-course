import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<String> stack = new ArrayDeque<>();

        while (!input.equals("Home")){
            String current = null;

            if (input.equals("back")) {
                if (stack.size() > 1) {
                    stack.pop();
                    current = stack.peek();
                    System.out.println(current);
                } else {
                    System.out.println("no previous URLs");
                }

            } else {
                stack.push(input);
                System.out.println(input);
            }

            input = scanner.nextLine();
        }
    }
}
