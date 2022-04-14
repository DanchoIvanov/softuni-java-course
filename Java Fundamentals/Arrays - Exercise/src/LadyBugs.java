import java.util.Arrays;
import java.util.Scanner;

public class LadyBugs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fieldSize = Integer.parseInt(scanner.nextLine());
        if (fieldSize<=0){
            return;
        }
        int[] field = new int[fieldSize];

        int[] LadyBugsIndexes = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int LadyBugsIndex : LadyBugsIndexes) {
            if (LadyBugsIndex >=0 && LadyBugsIndex < field.length) {
                field[LadyBugsIndex] = 1;
            }
        }
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            String[] flyCommands = command.split(" ");
            int index = Integer.parseInt(flyCommands[0]);
            String direction = flyCommands[1];
            int flightLength = Integer.parseInt(flyCommands[2]);

            if (index >= 0 && index < field.length && field[index] == 1) {
                field[index] = 0;
                if (direction.equals("right")) {
                    index += flightLength;
                    while (0 >= index &&  index < field.length && field[index] == 1) {
                        index += flightLength;
                    }
                    if (index >= 0 && index < field.length) {
                        field[index] = 1;
                    }
                } else if (direction.equals("left")) {
                    index -= flightLength;
                    while (index >= 0 && index < field.length && field[index] == 1) {
                        index -= flightLength;
                    }
                    if (index >= 0 && index < field.length) {
                        field[index] = 1;
                    }
                }
            }
            command = scanner.nextLine();
        }
        for (int ladyBug : field) {
            System.out.printf("%d ", ladyBug);
        }
    }
}