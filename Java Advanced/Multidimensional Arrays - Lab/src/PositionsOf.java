import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matrixRows = Integer.parseInt(scanner.nextLine().split("\\s+")[0]);
        int[][] matrix = readMatrix(matrixRows, scanner);
        int searchedNumber = Integer.parseInt(scanner.nextLine());

        printSearchedNumberPositions(searchedNumber, matrix);
    }

    private static void printSearchedNumberPositions(int searchedNumber, int[][] matrix) {

        boolean isFound = false;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == searchedNumber){
                    isFound = true;
                    System.out.println(row + " " + col);
                }
            }
        }
        if (!isFound) {
            System.out.println("not found");
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

