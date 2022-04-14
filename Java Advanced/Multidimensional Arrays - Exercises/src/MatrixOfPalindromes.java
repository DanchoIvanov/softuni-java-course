import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = createAMatrixOfPalindromes(rows,cols);
        printMatrix(matrix);

    }

    private static String[][] createAMatrixOfPalindromes(int rows, int cols) {
        char firstChar = 'a';
        String arr[][] = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                StringBuilder element = new StringBuilder();
                element.append(((char)(firstChar + row)));
                element.append((char)(firstChar + row + col));
                element.append((char)(firstChar + row));
                arr[row][col] = element.toString();
            }
        }
        return arr;
    }
    private static void printMatrix (String[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col <matrix[row].length ; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
