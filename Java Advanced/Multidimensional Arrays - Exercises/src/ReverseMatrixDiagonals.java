import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int[][] matrix = readMatrix(rows, scanner);

        for (int col = matrix[0].length -1; col >= 0 ; col--) {
            int row = matrix.length -1;
            for (int j = 0; j < matrix.length; j++) {
                if (col + j < matrix[0].length && row - j >= 0){
                    System.out.print(matrix[row - j][col + j] + " ");
                } else {
                    break;
                }
            }
            System.out.println();
        }

        for (int row = matrix.length -2; row >= 0 ; row--) {
            int col = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                if (row - j >= 0){
                    System.out.print(matrix[row - j][col + j] + " ");
                } else {
                    break;
                }
            }
            System.out.println();
        }
    }
    private static int[][] readMatrix(int matrixRows, Scanner scanner) {
        int[][] matrix = new int[matrixRows][];
        for (int i = 0; i < matrixRows; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[i] = arr;
        }
        return matrix;
    }
}
