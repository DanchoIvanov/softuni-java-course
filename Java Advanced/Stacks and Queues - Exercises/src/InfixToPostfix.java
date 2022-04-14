import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(" ");
        ArrayDeque<String> outputQueue = new ArrayDeque<>();
        ArrayDeque<String> operatorsStack = new ArrayDeque<>();
        String numberRegex = "[0-9]+|[a-z]";
        Pattern pattern = Pattern.compile(numberRegex);
        for (String token : tokens){
            Matcher matcher = pattern.matcher(token);
            if (matcher.find()){
                outputQueue.offer(token);
            } else {
                if (operatorsStack.isEmpty() || operatorsStack.peek().equals("(")){
                    operatorsStack.push(token);
                } else {
                    switch (token){
                        case "+":
                        case "-":
                            if (operatorsStack.peek().equals("-") || operatorsStack.peek().equals("+") ){
                                outputQueue.offer(operatorsStack.pop());
                                operatorsStack.push(token);
                            } else if (operatorsStack.peek().equals("*") || operatorsStack.peek().equals("/") || operatorsStack.peek().equals("(")) {
                                operatorsStack.push(token);
                            }
                            break;
                        case "*":
                        case "/":
                            if (operatorsStack.peek().equals("*") || operatorsStack.peek().equals("/+") ){
                                outputQueue.offer(operatorsStack.pop());
                                operatorsStack.push(token);
                            } else if (operatorsStack.peek().equals("+") || operatorsStack.peek().equals("-") || operatorsStack.peek().equals("(")) {
                                operatorsStack.addFirst(token);
                            }
                            break;
                        case ")":
                            while (!operatorsStack.isEmpty()) {
                                if (!operatorsStack.peek().equals("(")) {
                                    outputQueue.offer(operatorsStack.pop());
                                } else {
                                    operatorsStack.pop();
                                    break;
                                }
                            }
                            break;
                    }
                }
            }
        }
        while (!operatorsStack.isEmpty()) {
            outputQueue.offer(operatorsStack.pop());
        }
        for (String element : outputQueue){
            System.out.print(element + " ");
        }
    }
}
