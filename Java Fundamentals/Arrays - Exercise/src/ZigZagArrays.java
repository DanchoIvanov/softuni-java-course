import java.util.Arrays;
import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] numbers1 = new int[n];
        int[] numbers2 = new int[n];

        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split(" ");
            if (i % 2 == 0){
                numbers2[i-1] = Integer.parseInt(input[0]);
                numbers1[i-1] = Integer.parseInt(input[1]);
            } else {
                numbers2[i-1] = Integer.parseInt(input[1]);
                numbers1[i-1] = Integer.parseInt(input[0]);
            }
        }
        for (int i = 0; i < numbers1.length; i++) {
            System.out.printf("%d ",numbers1[i]);
        }
        System.out.println();
        for (int i = 0; i < numbers2.length; i++) {
            System.out.printf("%d ",numbers2[i]);
        }
    }
}
