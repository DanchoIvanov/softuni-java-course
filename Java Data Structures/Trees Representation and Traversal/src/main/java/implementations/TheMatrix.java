package implementations;

public class TheMatrix {
    private char[][] matrix;
    private char fillChar;
    private char toBeReplaced;
    private int startRow;
    private int startCol;

    public TheMatrix(char[][] matrix, char fillChar, int startRow, int startCol) {
        this.matrix = matrix;
        this.fillChar = fillChar;
        this.startRow = startRow;
        this.startCol = startCol;
        this.toBeReplaced = this.matrix[this.startRow][this.startCol];
    }

    public void solve() {

        dfs(startRow, startCol);

    }

    private void dfs(int row, int col) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length) {
            return;
        }

        if (matrix[row][col] == this.toBeReplaced) {
            matrix[row][col] = fillChar;
            dfs(row + 1, col);
            dfs(row, col + 1);
            dfs(row - 1, col);
            dfs(row, col - 1);
        }
    }

    public String toOutputString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                sb.append(matrix[row][col]);
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
