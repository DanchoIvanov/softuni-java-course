import java.util.Scanner;

public class NumberPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int currentCount = 1;
        boolean isBigger = false;

        int n = Integer.parseInt(scanner.nextLine());
        for (int rows = 1; rows <= n; rows++) {
            for (int columns = 1; columns <= rows; columns++) {
                if (currentCount > n) {
                    isBigger = true;
                    break;
                }
                System.out.printf("%d ", currentCount);
                currentCount++;
            }
            if (currentCount > n) {
                isBigger = true;
                break;
            }
            System.out.println();
        }
    }
}
