public class TheEightQueensPuzzle {

    static char[][] chessboard;
    static int[][] attackedPositions = new int[8][8];
    public static void main(String[] args) {
        chessboard = createEmptyChessBoard();
        placeQueen(0);

    }

    private static void placeQueen(int row) {
        for (int col = 0; col < 8; col++) {
            if (attackedPositions[row][col] == 0){
                chessboard[row][col] = '*';
                markAttackedPositions(row, col);
                if (row < 7) {
                    placeQueen(row + 1);
                } else {
                    printChessBoard();
                }
                unmarkAttackedPositions(row, col);
                chessboard[row][col] = '-';
            }
        }
    }

    private static void printChessBoard() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                System.out.print(chessboard[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void markAttackedPositions(int row, int col) {
        markAttackedColumn(row, col, 1);
        markLeftAttackedDiagonal(row, col, 1);
        markRightAttackedDiagonal(row, col, 1);
    }

    private static void unmarkAttackedPositions(int row, int col) {
        markAttackedColumn(row ,col, -1);
        markLeftAttackedDiagonal(row, col, -1);
        markRightAttackedDiagonal(row, col, -1);
    }

    private static void markRightAttackedDiagonal(int row, int col, int value) {
        while (row < 8 && col < 8){
            attackedPositions[row][col] += value;
            row++;
            col++;
        }
    }

    private static void markLeftAttackedDiagonal(int row, int col, int value) {
        while (row < 8 && col >= 0){
            attackedPositions[row][col] += value;
            row++;
            col--;
        }
    }

    private static void markAttackedColumn(int row, int col, int value) {
        for (int i = row; i < 8; i++) {
            attackedPositions[i][col] += value;
        }
    }

    private static char[][] createEmptyChessBoard() {
        char[][] matrix = new char[8][8];
        for (int i = 0; i < 8; i++) {
            matrix[i] = new char[]{'-', '-', '-', '-', '-', '-', '-', '-'};
        }
        return matrix;
    }
}
