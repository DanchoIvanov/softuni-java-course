package listy_iterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        ListyIterator listyIterator = new ListyIterator();
        while (!input[0].equals("END")){
            String command = input[0];
            switch (command){
                case "Create":
                    listyIterator.create(Arrays.copyOfRange(input, 1, input.length));
                    System.out.println();
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "Print":
                    System.out.println(listyIterator.get());
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "PrintAll":
                    listyIterator.forEach(e -> System.out.print(e + " "));
                    System.out.println();
                    break;
            }
            input = scanner.nextLine().split("\\s+");
        }
    }
}
