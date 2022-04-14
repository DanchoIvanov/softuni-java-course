import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimension = Integer.parseInt(scanner.nextLine());
        int[][] matrix = readMatrix(dimension, scanner, "\\s+");

        System.out.println(Math.abs(getPrimeDiagonal(matrix)-getSecondaryDiagonal(matrix)));
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
    private static int getSecondaryDiagonal(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length ; i++) {
            sum += matrix[matrix.length -1 - i][i];
        }
        return sum;
    }

    private static int getPrimeDiagonal(int[][] matrix) {
        int sum =0;
        for (int i = 0; i < matrix.length ; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }
}
