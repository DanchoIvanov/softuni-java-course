import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        int rotation = 0;
        String rotationRegex = "[0-9]+";
        Pattern pattern = Pattern.compile(rotationRegex);
        Matcher matcher = pattern.matcher(command);
        if (matcher.find()){
            rotation = Integer.parseInt(matcher.group());
        }
        String[][] matrix = createMatrix(scanner);

        rotation = rotation % 360;

        switch (rotation){
            case 0:
                printMatrix(matrix);
                break;
            case 90:
                String[][] flippedMatrix = get90DegreeFlippedMatrix(matrix);
                printMatrix(flippedMatrix);
                break;
            case 180:
                flippedMatrix = get180DegreeFlippedMatrix(matrix);
                printMatrix(flippedMatrix);
                break;
            case 270:
                flippedMatrix = get270DegreeFlippedMatrix(matrix);
                printMatrix(flippedMatrix);
                break;
        }


    }

    private static String[][] get270DegreeFlippedMatrix(String[][] matrix) {
        String [][] arr = new String[matrix[0].length][matrix.length];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                arr[matrix[0].length - 1 - col][row] = matrix [row][col];
            }
        }
        return arr;
    }

    private static String[][] get180DegreeFlippedMatrix(String[][] matrix) {
        String [][] arr = new String[matrix.length][matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                arr[matrix.length - 1 - row][matrix[0].length - 1 - col] = matrix [row][col];
            }
        }
        return arr;
    }

    private static String[][] get90DegreeFlippedMatrix(String[][] matrix) {
        String [][] arr = new String[matrix[0].length][matrix.length];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                arr[col][matrix.length - 1 - row] = matrix [row][col];
            }
        }
        return arr;
    }

    private static String[][] createMatrix(Scanner scanner) {
        List<String> input = new ArrayList<>();
        int cols = 0;
        String command = scanner.nextLine();
        while (!command.equals("END")){
            input.add(command);
            if (command.length() > cols){
                cols= command.length();
            }
            command = scanner.nextLine();
        }
        int rows = input.size();

        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols ; col++) {
                if (col < input.get(row).length()){
                    matrix[row][col] = String.valueOf(input.get(row).charAt(col));
                } else {
                    matrix[row][col] = " ";
                }
            }
        }
        return matrix;
    }

    private static void printMatrix (String[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col <matrix[row].length ; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
