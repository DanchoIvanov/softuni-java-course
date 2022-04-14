import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Socks {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] left = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] right = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] smallerArr = left;
        int[] largerArr = right;

        if (right.length < left.length) {
            smallerArr = right;
            largerArr = left;
        }

        int[][] dp = new int[smallerArr.length + 1][largerArr.length + 1];

        for (int i = 1; i <= smallerArr.length; i++) {
            for (int j = 1; j <= largerArr.length; j++) {
                if (smallerArr[i - 1] == largerArr[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[smallerArr.length][largerArr.length]);
    }
}
