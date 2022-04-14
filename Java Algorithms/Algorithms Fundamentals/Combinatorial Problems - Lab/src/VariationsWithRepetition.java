import java.util.Scanner;

public class VariationsWithRepetition {
    private static String[] input;
    private static String variations[];
    private static int k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        input = scanner.nextLine().split("\\s+");
        k = Integer.parseInt(scanner.nextLine());

        variations = new String[k];
        variate(0);
    }

    private static void variate(int index) {
        if (index >= k) {
            print();
            return;
        }

        for (int i = 0; i < input.length; i++) {
            variations[index] = input[i];
            variate(index + 1);
        }
    }

    private static void print(){
        System.out.println(String.join(" ", variations));
    }
}
