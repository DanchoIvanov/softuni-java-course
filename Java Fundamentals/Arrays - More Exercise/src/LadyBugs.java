import java.util.Arrays;
import java.util.Scanner;

public class LadyBugs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fieldSize = Integer.parseInt(scanner.nextLine());
        if (fieldSize<=0){
            return;
        }
        int[] ladyBugs = new int[fieldSize];

        int[] LadyBugPositions = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int ladyBugPosition : LadyBugPositions) {
            if (ladyBugPosition >=0 && ladyBugPosition < ladyBugs.length) {
                ladyBugs[ladyBugPosition] = 1;
            }
        }
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] flyCommands = input.split(" ");

            if (Integer.parseInt(flyCommands[0]) >= 0 && Integer.parseInt(flyCommands[0]) < ladyBugs.length) {
                if (ladyBugs[Integer.parseInt(flyCommands[0])] == 1){
                        ladyBugs[Integer.parseInt(flyCommands[0])] = 0;
                    if (flyCommands[1].equals("right")) {
                        int i = 0;
                        int moveIndex = Integer.parseInt(flyCommands[0]) + Integer.parseInt(flyCommands[2]);
                        while (moveIndex + i >= 0 && moveIndex + i < ladyBugs.length) {
                            if (ladyBugs[moveIndex + i] == 0) {
                                ladyBugs[moveIndex + i] = 1;
                                break;
                            }
                            i += Integer.parseInt(flyCommands[2]);
                        }
                    } else if (flyCommands[1].equals("left")) {
                        int i = 0;
                        int moveIndex = Integer.parseInt(flyCommands[0]) - Integer.parseInt(flyCommands[2]);
                        while (moveIndex - i >= 0 && moveIndex - i < ladyBugs.length) {
                            if (ladyBugs[moveIndex - i] == 0) {
                                ladyBugs[moveIndex - i] = 1;
                                break;
                            }
                            i += Integer.parseInt(flyCommands[2]);
                        }
                    }
                }
            }
            input = scanner.nextLine();
        }
        for (int ladyBug : ladyBugs) {
            System.out.printf("%d ", ladyBug);
        }
    }
}