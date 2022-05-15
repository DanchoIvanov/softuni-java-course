import implementations.BalancedParentheses;
import implementations.DoublyLinkedList;
import interfaces.LinkedList;

public class Main {
    public static void main(String[] args) {

        BalancedParentheses balancedParentheses = new BalancedParentheses("{[()]}");
        System.out.println(balancedParentheses.solve());
    }
}
