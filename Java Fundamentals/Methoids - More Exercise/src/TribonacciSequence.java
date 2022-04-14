import java.util.Scanner;

public class TribonacciSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        getTribonacci(n);
    }

    private static void getTribonacci(int n) {
        int [] arr = new int[n];

        for (int i = 0; i < n; i++) {
            if (i == 0 || i == 1){
                arr[i] = 1;
            } else if (i == 2){
                arr[i] = 2;
            } else {
                arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
            }
            System.out.printf("%d ",arr[i]);
        }
    }
}
