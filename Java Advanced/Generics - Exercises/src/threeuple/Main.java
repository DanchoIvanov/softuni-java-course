package threeuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        Threeuple<String, String, String> threeuple1 =
                new Threeuple<String, String, String>((input[0] + " " + input[1]), input[2], input[3]);
        System.out.printf("%s -> %s -> %s%n", threeuple1.getItem1(), threeuple1.getItem2(), threeuple1.getItem3());
        input = scanner.nextLine().split("\\s+");
        Threeuple<String, Integer, Boolean> threeuple2 =
                new Threeuple<String, Integer, Boolean>(input[0], Integer.parseInt(input[1]), input[2].equals("drunk"));
        System.out.printf("%s -> %d -> %s%n", threeuple2.getItem1(), threeuple2.getItem2(), threeuple2.getItem3());
        input = scanner.nextLine().split("\\s+");
        Threeuple<String, Double, String> threeuple3 =
                new Threeuple<String, Double, String>(input[0], Double.parseDouble(input[1]), input[2]);
        System.out.printf("%s -> %s -> %s%n", threeuple3.getItem1(), threeuple3.getItem2(), threeuple3.getItem3());
    }
}
