import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimensions = Integer.parseInt(scanner.nextLine());
        int[][] matrix = readMatrix(dimensions,scanner,"\\s+");

        printPrimeDiagonal(matrix);
        printSecondaryDiagonal(matrix);

    }

    private static void printSecondaryDiagonal(int[][] matrix) {
        for (int i = 0; i < matrix.length ; i++) {
            System.out.print(matrix[matrix.length -1 - i][i] + " ");
        }
        System.out.println();
    }

    private static void printPrimeDiagonal(int[][] matrix) {
        for (int i = 0; i < matrix.length ; i++) {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();
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
