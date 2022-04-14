import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder currentString = new StringBuilder();
        ArrayDeque <String> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String command = input.split("\\s+")[0];
            switch (command){
                case "1":
                    String stringToAppend = input.split("\\s+")[1];
                    currentString.append(stringToAppend);
                    stack.push(currentString.toString());
                    break;
                case "2":
                    int count = Integer.parseInt(input.split("\\s+")[1]);
                    int startIndex = currentString.length() - count;
                    currentString.delete(startIndex, currentString.length());
                    stack.push(currentString.toString());
                    break;
                case "3":
                    int index = Integer.parseInt(input.split("\\s+")[1]);
                    System.out.println(currentString.charAt(index-1));
                    break;
                case "4":
                    stack.pop();
                    if (stack.size() >= 1) {
                        currentString = new StringBuilder(stack.peek());
                    } else {
                        currentString = new StringBuilder();
                    }
            }
        }
    }
}
