import java.util.Scanner;

public class Python {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pythonSize = 1;
        int size = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(", ");
        char[][] track = createMatrix(scanner, size);
        int foodCount = getFoodCount(track);
        int[] snakeLocation = getPlayersLocation(track);
        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            int[] newLocation = getNewLocation(command, track, snakeLocation);
            char currentSymbol = track[newLocation[0]][newLocation[1]];
            switch (currentSymbol) {
                case 'e':
                    System.out.println("You lose! Killed by an enemy!");
                    return;
                case 'f':
                    pythonSize++;
                    foodCount--;
                    if (foodCount == 0) {
                        System.out.println("You win! Final python length is " + pythonSize);
                        return;
                    }

            }
            snakeLocation = newLocation;
        }
        System.out.println("You lose! There is still " + foodCount + " food to be eaten.");
    }

    private static int getFoodCount(char[][] track) {
        int count = 0;
        for (int rows = 0; rows < track.length; rows++) {
            for (int cols = 0; cols < track.length; cols++) {
                if (track[rows][cols] == 'f'){
                    count++;
                }
            }
        }
        return count;
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
            String currentRow = scanner.nextLine();
            currentRow = currentRow.replaceAll("\\s+","");
            char[] row = currentRow.toCharArray();
            matrix[i] = row;
        }
        return matrix;
    }

    private static int[] getPlayersLocation(char[][] track){
        int[] location = new int[2];
        for (int row = 0; row < track.length; row++) {
            for (int col = 0; col < track[0].length; col++) {
                if (track[row][col] == 's'){
                    location[0] = row;
                    location[1] = col;
                    return location;
                }
            }
        }
        return location;
    }
}
