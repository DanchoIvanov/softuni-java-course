import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AlphaDecay {
    public static int[] numbers;
    public static int k;
    public static int[] result;
    public static boolean [] used;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        k = Integer.parseInt(reader.readLine());

        result = new int[k];
        used = new boolean[numbers.length];

        permute(0);
        System.out.println(sb.toString().trim());
    }

    private static void permute(int index) {
        if (index >= k) {
            print();
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (!used[i]) {
                used[i] = true;
                result[index] = numbers[i];
                permute(index + 1);
                used[i] = false;

            }
        }
    }

    public static void print() {
        for (int number : result) {
            sb.append(number).append(" ");
        }
        sb.append(System.lineSeparator());
    }
}
