import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PathsInLabyrinth {

    static List<String> path = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] labyrinth =  readMatrix(rows, scanner);

        move(0, 0, labyrinth, "r");

    }

    private static void move(int row, int col, char[][] labyrinth, String direction) {
        if (!isInBounds(row, col, labyrinth)
                || labyrinth[row][col] == '*'
                || labyrinth[row][col] == 'V'){
            return;
        }

        if (labyrinth[row][col] == 'e'){
            path.add(direction);
            print(path);
            path.remove(path.size()-1);
            return;
        }

        mark(row, col, labyrinth, direction);
        move(row +1, col, labyrinth, "D");
        move(row, col + 1, labyrinth, "R");
        move(row, col -1, labyrinth, "L");
        move(row - 1, col, labyrinth, "U");
        unmark(row, col, labyrinth);

    }

    private static void mark(int row, int col, char[][] labyrinth, String direction) {
        labyrinth[row][col] = 'V';
        path.add(direction);
    }

    private static void unmark(int row, int col, char[][] labyrinth) {
        labyrinth[row][col] = '-';
        path.remove(path.size()-1);;
    }

    private static void print(List<String> path) {
        for (int i = 1; i < path.size() ; i++) {
            System.out.print(path.get(i));
        }
        System.out.println();
    }

    private static boolean isInBounds(int row, int col, char[][] labyrinth) {
        return row >=0 && row < labyrinth.length && col >= 0 && col < labyrinth[0].length;
    }

    private static char[][] readMatrix(int rows, Scanner scanner) {
        char[][] matrix = new char[rows][];

        for (int i = 0; i < rows; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
        }

        return matrix;
    }
}
