package implementations;


import interfaces.Solvable;

import java.util.Deque;

public class BalancedParentheses implements Solvable {
    private String parentheses;
    private Deque<Character> stack;

    public BalancedParentheses(String parentheses) {
        this.parentheses = parentheses;
        this.stack = new java.util.ArrayDeque<>();
    }

    @Override
    public Boolean solve() {
        for (char character : parentheses.toCharArray()) {
            if (character == '(' || character == '[' || character == '{') {
                stack.push(character);
            } else if (character == ')' || character == ']' || character == '}'){
                if (stack.isEmpty()) {
                    return false;
                }
                char openParentheses = stack.pop();
                if (openParentheses == '(' && character != ')') {
                    return false;
                } else if (openParentheses == '[' && character != ']') {
                    return false;
                } else if (openParentheses == '{' && character != '}') {
                    return false;
                }
            }
        }
        return true;
    }
}
