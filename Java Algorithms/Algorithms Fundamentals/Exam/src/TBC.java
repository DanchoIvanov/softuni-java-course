import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TBC {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static char[][] matrix;
    public static boolean[][] visited;
    public static void main(String[] args) throws IOException {

        int rows = Integer.parseInt(reader.readLine());
        int cols = Integer.parseInt(reader.readLine());

        matrix = readMatrix(rows);
        visited = new boolean[rows][cols];
        int tunnelCount = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == 't' && !visited[row][col]) {
                    tunnelCount++;
                    connectTunnel(row, col);
                }
                visited[row][col] = true;
            }
        }
        System.out.println(tunnelCount);
    }

    private static void connectTunnel(int row, int col) {
        if (!isInBounds(row, col) || visited[row][col] || matrix[row][col] != 't') {
            return;
        }

        visited[row][col] = true;

        connectTunnel(row - 1, col);
        connectTunnel(row + 1, col);
        connectTunnel(row, col - 1);
        connectTunnel(row, col + 1);
        connectTunnel(row - 1, col - 1);
        connectTunnel(row + 1, col + 1);
        connectTunnel(row + 1, col - 1);
        connectTunnel(row - 1, col + 1);
    }

    private static boolean isInBounds(int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
    }

    private static char[][] readMatrix(int rows) throws IOException {
        char[][] matrix = new char[rows][];

        for (int i = 0; i < rows; i++) {
            matrix[i] = reader.readLine().toCharArray();
        }

        return matrix;
    }
}
