import java.util.Arrays;
import java.util.Scanner;

public class FormulaOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int commands = Integer.parseInt(scanner.nextLine());
        char[][] track = createMatrix(scanner, size);
        int[] location = getPlayersLocation(track);
        int[] playerStartLocation = Arrays.copyOf(location, 2);
        char currentSymbol = '.';
        for (int i = 0; i < commands; i++) {
            String command = scanner.nextLine();
            int[] newLocation = getNewLocation(command, track, location);
            currentSymbol = track[newLocation[0]][newLocation[1]];
            if (currentSymbol == '.') {
                location = newLocation;
            } else if (currentSymbol == 'B') {
                newLocation = getNewLocation(command, track, newLocation);
                location = newLocation;
            } else if (currentSymbol == 'F') {
                location = newLocation;
                break;
            }
        }
        if (currentSymbol == 'F'){
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }
        track[location[0]][location[1]] = 'P';
        track[playerStartLocation[0]][playerStartLocation[1]] = '.';
        printMatrix(track);

    }

    private static void printMatrix(char[][] track) {
        for (int row = 0; row < track.length; row++) {
            for (int col = 0; col < track.length; col++) {
                System.out.print(track[row][col]);
            }
            System.out.println();
        }
    }

    private static int[] getNewLocation (String command, char[][] track, int[] location) {
        int[] newLocation = new int[2];
        switch (command) {
            case "down":
                newLocation = moveToNewLocation(track, location, 1, 0);
                break;
            case "up":
                newLocation = moveToNewLocation(track, location, -1, 0);
                break;
            case "right":
                newLocation = moveToNewLocation(track, location, 0, 1);
                break;
            case "left":
                newLocation = moveToNewLocation(track, location, 0, -1);
                break;
        }
        return newLocation;
    }



    private static int[] moveToNewLocation(char[][] track, int[] location, int rowOffset, int colOffset) {
        int[] newLocation = new int[2];
        newLocation[0] = location[0] + rowOffset;
        newLocation[1] = location[1] + colOffset;

        if (newLocation[0] >= track.length) {
            newLocation[0] = 0;
        } else if (newLocation[0] < 0) {
            newLocation[0] = track.length - 1;
        } else if (newLocation[1] >= track.length) {
            newLocation[1] = 0;
        } else if (newLocation[1] < 0) {
            newLocation[1] = track.length - 1;
        }
        return newLocation;
    }

    private static char[][] createMatrix(Scanner scanner, int size) {
        char[][] matrix = new char[size][];
        for (int i = 0; i < size; i++) {
            char[] row = scanner.nextLine().toCharArray();
            matrix[i] = row;
        }
        return matrix;
    }

    private static int[] getPlayersLocation(char[][] track){
        int[] location = new int[2];
        for (int row = 0; row < track.length; row++) {
            for (int col = 0; col < track[0].length; col++) {
                if (track[row][col] == 'P'){
                    location[0] = row;
                    location[1] = col;
                    return location;
                }
            }
        }
        return location;
    }
}