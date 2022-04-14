import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Character> stack = new ArrayDeque<>();

        if (input.length() % 2 == 1){
            System.out.println("NO");
            return;
        }

        for (char character : input.toCharArray()) {
            if (character == '(' || character == '[' || character == '{') {
                stack.push(character);
            } else {
                switch (character){
                    case ']':
                        if (stack.pop() !='['){
                            System.out.println("NO");
                            return;
                        }
                        break;
                    case ')':
                        if (stack.pop() !='('){
                            System.out.println("NO");
                            return;
                        }
                        break;
                    case '}':
                        if (stack.pop() !='{'){
                            System.out.println("NO");
                            return;
                        }
                        break;
                }
            }
        }
        System.out.println("YES");
    }
}
