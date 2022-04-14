import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] tokens = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Arrays.stream(tokens).mapToInt(Integer::parseInt).forEach(stack::push);
        for (Integer number : stack){
            System.out.print(number + " ");
        }
    }
}
