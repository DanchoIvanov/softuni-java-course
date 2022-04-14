import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int element:lis(numbers)){
            System.out.printf("%d ",element);
        }

    }
    static int[] lis(int numbers[]) {
        int lis[] = new int[numbers.length];
        int previous[] = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++)
            lis[i] = 1;

        int max = 1;
        int index = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < i; j++) {
                if (numbers[i] > numbers[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                    previous[i] = j;
                    if (lis[i] > max) {
                        max = lis[i];
                        index = i;
                    }
                }
            }
        }
        int[] arr = new int[max];
        for (int i = max -1; i >=0; i--) {
            arr[i] = numbers[index];
            index = previous[index];
        }
        return arr;
    }
}
