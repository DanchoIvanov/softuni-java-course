import java.util.Scanner;

public class PermutationsWithoutRepetition {
    private static String[] input;
    private static boolean[] used;
    private static String perm[];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        input = scanner.nextLine().split("\\s+");
        used = new boolean[input.length];
        perm = new String[input.length];
        permute(0);
    }

    private static void permute(int index) {
        if (index >= input.length) {
            print();
            return;
        }

        for (int i = 0; i < input.length; i++) {
            if (!used[i]) {
                used[i] = true;
                perm[index] = input[i];
                permute(index + 1);
                used[i] = false;

            }
        }
    }

    private static void print(){
        System.out.println(String.join(" ", perm));
    }
}
