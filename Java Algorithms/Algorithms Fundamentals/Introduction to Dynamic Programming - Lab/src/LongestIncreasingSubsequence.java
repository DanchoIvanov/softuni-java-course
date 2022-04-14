import java.util.*;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] len = new int[numbers.length];
        int[] prev = new int[numbers.length];
        int maxLength = 0;
        int bestIndex = -1;

        for (int i = 0; i < numbers.length; i++) {
            int currentLength = 1;
            int index = -1;
            for (int j = i-1; j >= 0 ; j--) {
                if (numbers[j] < numbers[i] && len[j] + 1 >= currentLength) {
                    currentLength = len[j] + 1;
                    index = j;
                }
            }
            len[i] = currentLength;
            if (maxLength < currentLength) {
                maxLength = currentLength;
                bestIndex = i;
            }
            prev[i] = index;
        }

        Deque<Integer> LIS = new ArrayDeque<>();

        while(bestIndex != -1) {
            LIS.push(numbers[bestIndex]);
            bestIndex = prev[bestIndex];
        }

        while(!LIS.isEmpty()) {
            System.out.print(LIS.pop() + " ");
        }
    }
}
