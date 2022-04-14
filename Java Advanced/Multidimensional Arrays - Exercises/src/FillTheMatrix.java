import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        int dimension = Integer.parseInt(input[0]);
        String matrixType = input[1];
        int[][] matrix = new int[dimension][dimension];

        if (matrixType.equals("A")){
            matrix = getATypeMatrix(dimension);
        } else if (matrixType.equals("B")){
            matrix = getBTypeMatrix(dimension);
        }

        printMatrix(matrix);
    }

    private static int[][] getBTypeMatrix(int dimension) {
        int[][] arr = new int[dimension][dimension];
        int count = 1;
        for (int col = 0; col < dimension; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < dimension; row++) {
                    arr[row][col] = count++;
                }
            } else {
                for (int row = dimension-1; row >= 0; row--) {
                    arr[row][col] = count++;
                }
            }
        }
        return arr;
    }

    private static int[][] getATypeMatrix(int dimension) {
        int[][] arr = new int[dimension][dimension];
        int count = 1;
        for (int col = 0; col < dimension; col++) {
            for (int row = 0; row < dimension; row++) {
                arr[row][col] = count++;
            }
        }

        return arr;
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
