import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        List<List<Integer>> matrix = createListMatrix(rows, cols);

        String input = scanner.nextLine();
        while (!input.equals("Nuke it from orbit")){
            int row = Integer.parseInt(input.split("\\s+")[0]);
            int col = Integer.parseInt(input.split("\\s+")[1]);
            int radius = Integer.parseInt(input.split("\\s+")[2]);
            bombTheMatrix(row, col, radius, matrix);
            input = scanner.nextLine();
        }
        printTheMatrix(matrix);
    }

    private static void printTheMatrix(List<List<Integer>> matrix) {
        for (List<Integer> integers : matrix) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    private static void bombTheMatrix(int row, int col, int radius, List<List<Integer>> matrix) {
        removeElementsAbove(row, col, radius, matrix);
        removeElementsBelow(row, col, radius, matrix);
        removeElementsOnTheRight(row, col, radius, matrix);
        removeElementsOnTheLeft(row, col, radius, matrix);
        removeEmptyRows(matrix);

    }

    private static void removeEmptyRows(List<List<Integer>> matrix) {
        for (int i = 0; i < matrix.size(); i++) {
            if (matrix.get(i).isEmpty()){
                matrix.remove(i);
                i--;
            }
        }
    }

    private static void removeElementsOnTheLeft(int row, int col, int radius, List<List<Integer>> matrix) {
        for (int i = 0; i <= radius  ; i++) {
            if (row >= 0 && row < matrix.size() ){
                if ((col - i) >= 0 && (col - i) < matrix.get(row).size() ){
                    matrix.get(row).remove((col - i));
                }
            }
        }
    }

    private static void removeElementsOnTheRight(int row, int col, int radius, List<List<Integer>> matrix) {
        for (int i = radius; i > 0  ; i--) {
            if (row >= 0 && row < matrix.size() ){
                if ((col + i) >= 0 && (col + i) < matrix.get(row).size()){
                    matrix.get(row).remove((col + i));
                }
            }
        }
    }

    private static void removeElementsBelow(int row, int col, int radius, List<List<Integer>> matrix) {
        for (int i = radius; i > 0; i--) {
            if ((row + i) < matrix.size() && (row + i) >= 0){
                if (col < matrix.get(row + i).size() && col >=0){
                    matrix.get(row + i).remove(col);
                }
            }
        }
    }

    private static void removeElementsAbove(int row, int col, int radius, List<List<Integer>> matrix) {
        for (int i = radius; i > 0; i--) {
            if ((row - i) >= 0 && (row - i) < matrix.size()){
                if (col < matrix.get(row - i).size() && col >= 0){
                    matrix.get(row-i).remove(col);
                }
            }
        }
    }

    private static List<List<Integer>> createListMatrix(int rows, int cols) {
        List<List<Integer>> matrix = new ArrayList<>();
        int count = 1;
        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(count++);
            }
        }
        return matrix;
    }
}
