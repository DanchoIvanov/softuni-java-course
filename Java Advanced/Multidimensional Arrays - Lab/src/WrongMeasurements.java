import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = readMatrix(rows, scanner, "\\s+");
        int[] wrongMeasurementCoordinates = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int wrongMeasurementRow = wrongMeasurementCoordinates[0];
        int wrongMeasurementCol = wrongMeasurementCoordinates[1];
        int wrongMeasurement = matrix[wrongMeasurementRow][wrongMeasurementCol];
        int[][] correctMatrix = getFixedMatrix(wrongMeasurement, matrix);
        printMatrix(correctMatrix);
    }

    private static int[][] getFixedMatrix(int wrongMeasurement, int[][] matrix) {
        int[][] arr = new int[matrix.length][];
        for (int row = 0; row < matrix.length; row++) {
            int[] tempArr = new int[matrix[row].length];
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] != wrongMeasurement){
                    tempArr[col] = matrix[row][col];
                } else {
                    tempArr[col] =  getCorrectValue(row, col, wrongMeasurement, matrix);
                }
            }
            arr[row] = tempArr;
        }
        return arr;
    }

    private static int getCorrectValue(int row, int col, int wrongMeasurement, int[][] matrix) {
        int sum = 0;
        if (row - 1 >= 0 && col < matrix[row-1].length){
            if (matrix[row-1][col] != wrongMeasurement) {
                sum += matrix[row - 1][col];
            }
        }
        if (row + 1 < matrix.length && col < matrix[row+1].length){
            if (matrix[row+1][col] != wrongMeasurement) {
                sum += matrix[row + 1][col];
            }
        }
        if (col - 1 >= 0){
            if (matrix[row][col-1] != wrongMeasurement) {
                sum += matrix[row][col-1];
            }
        }
        if (col + 1 < matrix[row].length){
            if (matrix[row][col+1] != wrongMeasurement) {
                sum += matrix[row][col+1];
            }
        }
        return sum;
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
