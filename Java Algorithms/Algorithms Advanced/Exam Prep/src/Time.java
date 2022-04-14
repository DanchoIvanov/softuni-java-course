import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Time {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] first = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] second = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();


        int[][] dp = new int[first.length+ 1][second.length + 1];

        for (int rowIndex = 1; rowIndex <= first.length; rowIndex++) {
            for (int colIndex = 1; colIndex <= second.length; colIndex++) {
                if (first[rowIndex - 1] == second[colIndex - 1]) {
                    dp[rowIndex][colIndex] =
                            dp[rowIndex - 1][colIndex - 1] + 1;
                } else {
                    dp[rowIndex][colIndex] = Math.max(
                            dp[rowIndex - 1][colIndex], dp[rowIndex][colIndex - 1]
                    );
                }
            }
        }
        List<Integer> sequence = new ArrayList<>();
        int row = first.length - 1;
        int col = second.length - 1;

        while (row >= 0 && col >= 0) {
            if (first[row] == second[col]) {
                sequence.add(first[row]);
                row--;
                col--;
            } else if (dp[row][col + 1] > dp[row + 1][col]) {
                row--;
            } else {
                col--;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = sequence.size() - 1; i >= 0 ; i--) {
            stringBuilder.append(sequence.get(i)).append(" ");
        }

        System.out.println(stringBuilder.toString().trim());
        System.out.println(dp[first.length][second.length]);
    }
}

