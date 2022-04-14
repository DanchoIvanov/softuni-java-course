import java.util.Scanner;
import java.util.TreeSet;

public class ConnectedAreasInMatrix {
    public static char[][] matrix;
    public static TreeSet<ConnectedArea> connectedAreas = new TreeSet<>();
    public static int currentAreaSize;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());
        matrix = createMatrix(scanner, rows);

        findFirstTraversableCell();
        printResult();
    }

    private static void printResult() {
        int areaNumber = 1;

        System.out.println("Total areas found: " + connectedAreas.size());

        for (ConnectedArea connectedArea : connectedAreas) {
            System.out.printf("Area #%d at (%d, %d), size: %d %n",areaNumber++, connectedArea.startRow, connectedArea.startCol, connectedArea.size);
        }
    }

    private static void findFirstTraversableCell() {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == '-') {
                    ConnectedArea area = new ConnectedArea(row, col);
                    currentAreaSize = 0;
                    findAreaSize(row, col, area);
                    area.setSize(currentAreaSize);
                    connectedAreas.add(area);
                    findFirstTraversableCell();
                }
            }
        }
    }

    private static void findAreaSize(int row, int col, ConnectedArea area) {

        matrix[row][col] = 'V';
        currentAreaSize++;

        if (isInBounds(row - 1, col)) {
            if (matrix[row - 1][col] == '-') {
                findAreaSize(row - 1, col, area);
            }
        }

        if (isInBounds(row + 1, col)) {
            if (matrix[row + 1][col] == '-') {
                findAreaSize(row + 1, col, area);
            }
        }

        if (isInBounds(row, col - 1)) {
            if (matrix[row][col - 1] == '-') {
                findAreaSize(row, col - 1, area);
            }
        }

        if (isInBounds(row, col + 1)) {
            if (matrix[row][col + 1] == '-') {
                findAreaSize(row, col + 1, area);
            }
        }

        area.setSize(currentAreaSize);
    }

    private static boolean isInBounds(int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
    }

    private static char[][] createMatrix(Scanner scanner, int rows) {
        char[][] matrix = new char[rows][];

        for (int i = 0; i < rows; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
        }

        return matrix;
    }

    private static class ConnectedArea implements Comparable<ConnectedArea> {
        private int size;
        private int startRow;
        private int startCol;

        ConnectedArea(int startRow, int startCol) {
            this.startRow = startRow;
            this.startCol = startCol;
        }

        public void setSize(int size) {
            this.size = size;
        }

        @Override
        public int compareTo(ConnectedArea o) {
            if (this.size < o.size) {
                return 1;
            } else if (this.size > o.size) {
                return -1;
            } else {
                if (this.startRow > o.startRow) {
                    return 1;
                } else if (this.startRow < o.startRow) {
                    return -1;
                } else {
                    if (this.startCol > o.startCol) {
                        return 1;
                    } else if (this.startCol < o.startCol) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            }
        }
    }
}
