import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] matrix = readMatrix(8,scanner,"\\s+");
        printRealQueenCoordinates(matrix);

    }

    private static void printRealQueenCoordinates(String[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            int queensCount = 0;
            int queenCol = 0;
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("q")){
                    queensCount++;
                    queenCol = col;
                }
            }
            if (queensCount == 1){
                queensCount = 0;
                int queenRow = 0;
                for (int i = 0; i < matrix.length; i++) {
                    if (matrix[i][queenCol].equals("q")){
                        queensCount++;
                        queenRow = i;
                    }
                }
                if (queensCount == 1){
                    boolean leftDiagonalIsNotAttacked = checkLeftDiagonal(queenRow, queenCol, matrix);
                    if (leftDiagonalIsNotAttacked) {
                        boolean rightDiagonalIsNotAttacked = checkRightDiagonal(queenRow, queenCol, matrix);
                        if (rightDiagonalIsNotAttacked) {
                            System.out.println(queenRow + " " + queenCol);
                            return;
                        }
                    }
                }
            }
        }
    }

    private static boolean checkRightDiagonal(int queenRow, int queenCol, String[][] matrix) {
        int i = 1;
        while (queenRow + i < matrix.length && queenCol - i >=0){
            if (matrix[queenRow + i][queenCol - i].equals("q")){
                return false;
            }
            i++;
        }
        while (queenCol + i < matrix.length && queenRow - i >=0){
            if (matrix[queenRow - i][queenCol + i].equals("q")){
                return false;
            }
            i++;
        }
        return true;
    }

    private static boolean checkLeftDiagonal(int queenRow, int queenCol, String[][] matrix) {
        int i = 1;
        while (queenRow - i >= 0 && queenCol - i >= 0 ){
            if (matrix[queenRow-i][queenCol-i].equals("q")){
                return false;
            }
            i++;
        }
        i = 1;
        while (queenRow + i < matrix.length && queenCol + i < matrix.length){
            if (matrix[queenRow+i][queenCol+i].equals("q")){
                return false;
            }
            i++;
        }
        return true;
    }

    private static String[][] readMatrix(int matrixRows, Scanner scanner, String delimiter) {
        String[][] matrix = new String[matrixRows][];
        for (int i = 0; i < matrixRows; i++) {
            String[] arr = scanner.nextLine().split(delimiter);

            matrix[i] = arr;
        }
        return matrix;
    }
}
