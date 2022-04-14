import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int MatricesRows = Integer.parseInt(scanner.nextLine());
        int MatricesCols = Integer.parseInt(scanner.nextLine());
        String [][] matrix1 = readMatrix(MatricesRows, scanner);
        String [][] matrix2 = readMatrix(MatricesRows, scanner);
        printIntersectedMatrix(matrix1, matrix2);

    }
    private static String[][] readMatrix(int matrixRows, Scanner scanner) {
        String[][] matrix = new String[matrixRows][];
        for (int i = 0; i < matrixRows; i++) {
            String[] arr = scanner.nextLine().split("\\s+");

            matrix[i] = arr;
        }
        return matrix;
    }

    private static void printIntersectedMatrix (String[][] firstMatrix, String[][] secondMatrix) {

        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col <firstMatrix[row].length ; col++) {
                if (!firstMatrix[row][col].equals(secondMatrix[row][col])){
                    System.out.print("* ");
                } else {
                    System.out.print(firstMatrix[row][col] + " ");
                }
            }
            System.out.println();
        }
    }
}
