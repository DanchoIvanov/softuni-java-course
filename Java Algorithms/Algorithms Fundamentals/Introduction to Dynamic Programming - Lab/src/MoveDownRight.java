import java.util.*;

public class MoveDownRight {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        int[][] matrix = readMatrix(rows);
        int[][] dp = new int[rows][cols];

        dp[0][0] = matrix[0][0];

        for (int i = 1; i < matrix[0].length ; i++) {
            dp[0][i] = matrix[0][i] + dp[0][i - 1];
        }

        for (int i = 1; i < matrix.length ; i++) {
            dp[i][0] = matrix[i][0] + dp[i - 1][0];
        }

        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                dp[row][col] = Math.max(matrix[row][col] + dp[row -1][col],
                        matrix[row][col] + dp[row][col - 1]);
            }
        }

        int row = rows - 1;
        int col = cols - 1;

        List<String> path = new ArrayList<>();

        path.add(formatOutput(row, col));

        while (row > 0 || col > 0) {

            int top = -1;

            if (row > 0) {
                top = dp[row - 1][col];
            }

            int left = -1;

            if (col > 0) {
                left = dp[row][col - 1];
            }

            if (top > left) {
                row--;
            } else {
                col--;
            }

            path.add(formatOutput(row, col));
        }

        Collections.reverse(path);

        System.out.println(String.join(" ", path));
    }

    private static String formatOutput(int row, int col) {
        return "[" + row + ", " + col + "]";
    }

    private static int[][] readMatrix(int rows) {
        int[][] matrix = new int[rows][];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        return matrix;
    }
}
