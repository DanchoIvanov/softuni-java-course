package scale;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Scale<Integer> scale = new Scale<>(3, 3);
        System.out.println(scale.getHeavier());

    }
}
