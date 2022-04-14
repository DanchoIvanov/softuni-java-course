import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstMatrixRows = Integer.parseInt(scanner.nextLine().split("\\s+")[0]);
        int[][] firstMatrix = readMatrix(firstMatrixRows, scanner);

        int secondMatrixRows = Integer.parseInt(scanner.nextLine().split("\\s+")[0]);
        int[][] secondMatrix = readMatrix(secondMatrixRows, scanner);

        boolean areEqual = matricesAreEqual(firstMatrix, secondMatrix);

        System.out.println(areEqual ? "equal" : "not equal");
    }

    private static boolean matricesAreEqual(int[][] firstMatrix, int[][] secondMatrix) {

        if (firstMatrix.length != secondMatrix.length){
            return false;
        }
        for (int row = 0; row < firstMatrix.length; row++) {
            if (firstMatrix[row].length != secondMatrix[row].length){
                return false;
            }
            for (int col = 0; col <firstMatrix[row].length ; col++) {
                if (firstMatrix[row][col] != secondMatrix[row][col]){
                    return false;
                }
            }
        }
        return true;
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