package stack;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Stack stack = new Stack();
        while (!input.equals("END")){
            String command = input.split("(, | )")[0];
            switch (command){
                case "Push":
                    int[] elements = Arrays.stream(input.split("(, | )")).skip(1).mapToInt(Integer::parseInt).toArray();
                    stack.push(elements);
                    break;
                case "Pop":
                    if (stack.pop() == null){
                        System.out.println("No elements");
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        stack.forEach(System.out::println);
        stack.forEach(System.out::println);
    }
}
