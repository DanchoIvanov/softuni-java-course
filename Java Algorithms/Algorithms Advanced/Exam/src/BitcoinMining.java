import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BitcoinMining {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int transactionsCount = Integer.parseInt(reader.readLine());

        List<String[]> transactions = new ArrayList<>();

        for (int i = 0; i < transactionsCount; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            transactions.add(tokens);
        }

        int capacity = 1000000;

        int[][] dp = new int[transactions.size() + 1][capacity + 1];
        boolean[][] takenTransaction = new boolean[transactions.size() + 1][capacity + 1];

        for (int transactionRow = 1; transactionRow <= transactions.size(); transactionRow++) {
            String[] currentTransaction = transactions.get(transactionRow - 1);
            String hash = currentTransaction[0];
            int size = Integer.parseInt(currentTransaction[1]);
            int fees = Integer.parseInt(currentTransaction[2]);
            String from = currentTransaction[3];
            String to = currentTransaction[4];
            for (int capacityCol = 0; capacityCol <= capacity; capacityCol++) {

                int excluded = dp[transactionRow - 1][capacityCol];
                if (capacityCol - size < 0) {
                    dp[transactionRow][capacityCol] = excluded;
                } else {
                    int included = dp[transactionRow - 1][capacityCol - size] + fees;

                    if (excluded > included) {
                        dp[transactionRow][capacityCol] = excluded;
                    } else {
                        dp[transactionRow][capacityCol] = included;
                        takenTransaction[transactionRow][capacityCol] = true;
                    }
                }
            }
        }
        int totalSize = capacity;

        int bestValue = dp[transactions.size()][capacity];

        while (dp[transactions.size()][totalSize - 1] == bestValue) {
            totalSize--;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Total Size: ").append(totalSize).append(System.lineSeparator());
        sb.append("Total Fees: ").append(bestValue).append(System.lineSeparator());

        int lastTransaction = transactions.size();

        while (lastTransaction > 0) {
            if (takenTransaction[lastTransaction][capacity]) {
                String transaction = transactions.get(lastTransaction - 1)[0];
                sb.append(transaction).append(System.lineSeparator());
                int size = Integer.parseInt(transactions.get(lastTransaction - 1)[1]);
                capacity -= size;
            }
            lastTransaction--;
        }

        System.out.println(sb.toString().trim());
    }
}