import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = readMatrix(rows, scanner, ", ");
        int maxSum = 0;
        int lastElementOfTheMaxSumMatrixRow = 0;
        int lastElementOfTheMaxSumMatrixCol = 0;

        for (int row = 0; row < rows-1 ; row++) {
            for (int col = 0; col < cols-1  ; col++) {
                int sum = 0;
                int lastElementRow = 0;
                int lastElementCol = 0;
                for (int i = row; i < row +2 ; i++) {

                    for (int j = col; j < col +2 ; j++) {
                        sum += matrix[i][j];
                        lastElementRow = i;
                        lastElementCol = j;
                    }
                }
                if (sum > maxSum){
                    maxSum = sum;
                    lastElementOfTheMaxSumMatrixRow = lastElementRow;
                    lastElementOfTheMaxSumMatrixCol = lastElementCol;
                }
            }
        }
        int[][] maxSumSubmatrix = new int[2][2];
        maxSumSubmatrix [0][0] = matrix[lastElementOfTheMaxSumMatrixRow - 1][lastElementOfTheMaxSumMatrixCol -1];
        maxSumSubmatrix [0][1] = matrix[lastElementOfTheMaxSumMatrixRow - 1][lastElementOfTheMaxSumMatrixCol];
        maxSumSubmatrix [1][0] = matrix[lastElementOfTheMaxSumMatrixRow][lastElementOfTheMaxSumMatrixCol - 1];
        maxSumSubmatrix [1][1] = matrix[lastElementOfTheMaxSumMatrixRow][lastElementOfTheMaxSumMatrixCol];

        printMatrix(maxSumSubmatrix);
        System.out.println(maxSum);

    }

    private static void printMatrix(int[][] maxSumSubmatrix) {
        for (int row = 0; row < maxSumSubmatrix.length; row++) {
            for (int col = 0; col < maxSumSubmatrix[row].length; col++) {
                System.out.print(maxSumSubmatrix[row][col] + " ");
            }
            System.out.println();
        }
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
}

