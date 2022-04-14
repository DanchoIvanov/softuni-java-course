import java.util.Scanner;

public class MouseAndCheese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] territory = createMatrix(scanner, size);
        int [] mouseLocation = getMouseLocation(territory);
        int[] newLocation;
        int cheeseEaten = 0;
        char currentChar;
        boolean mouseIsInBounds = true;
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            newLocation = getNewLocation(command, mouseLocation);
            mouseIsInBounds = isInBounds(newLocation, size);

            if (!mouseIsInBounds){
                territory[mouseLocation[0]][mouseLocation[1]] = '-';
                break;
            }
            currentChar = territory[newLocation[0]][newLocation[1]];
            if (currentChar == 'B') {
                territory[newLocation[0]][newLocation[1]] = '-';
                newLocation = getNewLocation(command, newLocation);
                currentChar = territory[newLocation[0]][newLocation[1]];
                if (currentChar == '-') {
                    territory[mouseLocation[0]][mouseLocation[1]] = '-';
                    territory[newLocation[0]][newLocation[1]] = 'M';
                    mouseLocation = newLocation;
                } else if (currentChar == 'c') {
                    territory[mouseLocation[0]][mouseLocation[1]] = '-';
                    territory[newLocation[0]][newLocation[1]] = 'M';
                    cheeseEaten++;
                    mouseLocation = newLocation;
                }
            } else if (currentChar == '-') {
                territory[mouseLocation[0]][mouseLocation[1]] = '-';
                territory[newLocation[0]][newLocation[1]] = 'M';
                mouseLocation = newLocation;
            } else if (currentChar == 'c') {
                territory[mouseLocation[0]][mouseLocation[1]] = '-';
                territory[newLocation[0]][newLocation[1]] = 'M';
                cheeseEaten++;
                mouseLocation = newLocation;
            }
            command = scanner.nextLine();
        }

        if (!mouseIsInBounds){
            System.out.println("Where is the mouse?");
        }

        if (cheeseEaten < 5){
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - cheeseEaten);
        } else {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", cheeseEaten);
        }
        printMatrix(territory);
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

    private static int[] getMouseLocation(char[][] territory){
        int[] location = new int[2];
        for (int row = 0; row < territory.length; row++) {
            for (int col = 0; col < territory[0].length; col++) {
                if (territory[row][col] == 'M'){
                    location[0] = row;
                    location[1] = col;
                    return location;
                }
            }
        }
        return location;
    }

    private static int[] moveToNewLocation(int[] location, int rowOffset, int colOffset) {
        int[] newLocation = new int[2];
        newLocation[0] = location[0] + rowOffset;
        newLocation[1] = location[1] + colOffset;

        return newLocation;
    }

    private static int[] getNewLocation (String command, int[] location) {
        int[] newLocation = new int[2];
        switch (command) {
            case "down":
                newLocation = moveToNewLocation(location, 1, 0);
                break;
            case "up":
                newLocation = moveToNewLocation(location, -1, 0);
                break;
            case "right":
                newLocation = moveToNewLocation(location, 0, 1);
                break;
            case "left":
                newLocation = moveToNewLocation(location, 0, -1);
                break;
        }
        return newLocation;
    }

    private static boolean isInBounds(int[] newLocation, int size) {
        return newLocation[0] >= 0 && newLocation[0] < size && newLocation[1] >= 0 && newLocation[1] < size;
    }

    private static void printMatrix(char[][] territory) {
        for (int row = 0; row < territory.length; row++) {
            for (int col = 0; col < territory.length; col++) {
                System.out.print(territory[row][col]);
            }
            System.out.println();

        }
    }
}
