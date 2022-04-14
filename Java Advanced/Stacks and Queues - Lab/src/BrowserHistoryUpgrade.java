import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> queue = new ArrayDeque<>();

        while (!input.equals("Home")){

            if (input.equals("back")) {
                if (stack.size() > 1) {
                    queue.addFirst(stack.pop());
                    System.out.println(stack.peek());
                } else {
                    System.out.println("no previous URLs");
                }
            } else if (input.equals("forward")) {
                if (!queue.isEmpty()){
                    stack.push(queue.peek());
                    System.out.println(queue.poll());
                } else {
                    System.out.println("no next URLs");
                }
            } else {
                stack.push(input);
                System.out.println(input);
                queue.clear();
            }


            input = scanner.nextLine();
        }
    }
}
