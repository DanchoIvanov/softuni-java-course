import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        int[][] matrix = readMatrix(rows, scanner, "\\s+");
        int maxSum = 0;
        int[][] maxSum3x3Matrix = new int[3][3];

        for (int i = 0; i < rows-2; i++) {
            for (int j = 0; j < cols-2; j++) {
                int sum =0;
                int[][] current3x3Matrix = new int[3][3];
                for (int row = i; row <= i+2; row++) {
                    for (int col = j; col <= j+2; col++) {
                        sum += matrix[row][col];
                        current3x3Matrix[row-i][col-j] = matrix[row][col];
                    }
                }
                if (sum > maxSum){
                    maxSum = sum;
                    maxSum3x3Matrix = current3x3Matrix;
                }
            }
        }
        System.out.println("Sum = " + maxSum);
        printMatrix(maxSum3x3Matrix);

    }
    private static int[][] readMatrix(int matrixRows, Scanner scanner, String delimiter) {
        int[][] matrix = new int[matrixRows][];
        for (int i = 0; i < matrixRows; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(delimiter))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[i] = arr;
        }
        return matrix;
    }

    private static void printMatrix (int[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col <matrix[row].length ; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
