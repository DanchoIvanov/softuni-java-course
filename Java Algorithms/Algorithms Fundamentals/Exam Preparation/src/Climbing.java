import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Climbing {
    public static int[][] matrix;
    public static int[][] dp;
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        matrix = readMatrix(rows);
        dp = new int[rows][cols];

        dp[dp.length -1][dp[0].length -1] = matrix [dp.length -1][dp[0].length -1];

        for (int i = dp.length -2; i >= 0 ; i--) {
            dp[i][dp[0].length -1] = dp[i + 1][dp[0].length -1] +  matrix[i][dp[0].length -1];
        }

        for (int i = dp[0].length -2; i >= 0 ; i--) {
            dp[dp.length -1][i] = dp[dp.length -1][i + 1] +  matrix[dp.length -1][i];
        }

        for (int row = dp.length -2; row >= 0; row--) {
            for (int col = dp[0].length -2; col >= 0; col--) {
                dp[row][col] = Math.max(matrix[row][col] +  dp[row + 1][col],
                        matrix[row][col] +  dp[row][col + 1]);
            }
        }

        System.out.println(dp[0][0]);

        int row = 0;
        int col = 0;

        List<Integer> path = new ArrayList<>();

        path.add(matrix[row][col]);

        while (row < rows -1 || col < cols -1) {

            int bottom = -1;

            if (row  < rows - 1) {
                bottom = dp[row + 1][col];
            }

            int right = -1;

            if (col < cols -1) {
                right = dp[row][col + 1];
            }

            if (bottom > right) {
                row++;
            } else {
                col++;
            }

            path.add(matrix[row][col]);
        }

        for (int i = path.size() -1; i >= 0 ; i--) {
            System.out.print(path.get(i) + " ");
        }
    }

    private static int[][] readMatrix(int rows) {
        int[][] matrix = new int[rows][];

        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }

        return matrix;
    }
}
