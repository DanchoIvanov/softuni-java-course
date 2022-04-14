package tuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        Tuple<String, String> tuple1 = new Tuple<>((input[0] + " " + input[1]), input[2]);
        System.out.printf("%s -> %s%n",tuple1.getItem1(), tuple1.getItem2());
        input = scanner.nextLine().split("\\s+");
        Tuple<String ,Integer> tuple2 = new Tuple<String, Integer>(input[0], Integer.parseInt(input[1]));
        System.out.printf("%s -> %d%n",tuple2.getItem1(), tuple2.getItem2());
        input = scanner.nextLine().split("\\s+");
        Tuple<Integer, Double> tuple3 = new Tuple<Integer, Double>(Integer.parseInt(input[0]), Double.parseDouble(input[1]));
        System.out.printf("%d -> %s%n",tuple3.getItem1(), tuple3.getItem2());
    }
}
