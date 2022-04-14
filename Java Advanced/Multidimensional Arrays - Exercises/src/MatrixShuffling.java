import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        String[][] matrix = readMatrix(rows, scanner, "\\s+");

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] command = input.split("\\s+");
            if (isValidCommand(command, rows,cols)) {

                String action = command[0];
                int row1 = Integer.parseInt(command[1]);
                int col1 = Integer.parseInt(command[2]);
                int row2 = Integer.parseInt(command[3]);
                int col2 = Integer.parseInt(command[4]);

                String element1 = matrix[row1][col1];
                String element2 = matrix[row2][col2];
                matrix[row1][col1] = element2;
                matrix[row2][col2] = element1;
                printMatrix(matrix);
            }
            else {
                System.out.println("Invalid input!");
            }
            input = scanner.nextLine();
        }
    }
    private static String[][] readMatrix(int matrixRows, Scanner scanner, String delimiter) {
        String[][] matrix = new String[matrixRows][];
        for (int i = 0; i < matrixRows; i++) {
            String[] arr = scanner.nextLine().split(delimiter);

            matrix[i] = arr;
        }
        return matrix;
    }

    private static void printMatrix (String[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col <matrix[row].length ; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isValidCommand(String[] command, int rows, int cols) {
        if (command.length != 5) {
            return false;
        }
        String action = command[0];
        if (!action.equals("swap")) {
            return false;
        }
        int row1 = Integer.parseInt(command[1]);
        int col1 = Integer.parseInt(command[2]);
        int row2 = Integer.parseInt(command[3]);
        int col2 = Integer.parseInt(command[4]);

        if (row1 >= 0 && row1 <rows && row2 >= 0 && row2 <rows && col1 >= 0 && col1 <cols && col2 >= 0 && col2 <cols) {
            return true;
        }
        return false;
    }
}
