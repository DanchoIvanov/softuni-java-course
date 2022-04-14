import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BattlePoints {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] requiredEnergy = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] points = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int energy = Integer.parseInt(reader.readLine());

        int[][] dp = new int[points.length + 1][energy + 1];

        for (int battleRow = 1; battleRow <= points.length; battleRow++) {
            for (int energyCol = 0; energyCol <= energy; energyCol++) {

                int excluded = dp[battleRow - 1][energyCol];
                if (energyCol - requiredEnergy[battleRow - 1] < 0) {
                    dp[battleRow][energyCol] = excluded;
                } else {
                    int included = dp[battleRow - 1][energyCol - requiredEnergy[battleRow - 1]] + points[battleRow -1];

                    if (excluded > included) {
                        dp[battleRow][energyCol] = excluded;
                    } else {
                        dp[battleRow][energyCol] = included;
                    }
                }
            }
        }
        System.out.println(dp[points.length][energy]);
    }
}
