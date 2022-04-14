package jedi_galaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int rows = dimensions[0];
            int cols = dimensions[1];

            Galaxy galaxy = new Galaxy(rows, cols);

            String command = scanner.nextLine();
            long starCount = 0;
            while (!command.equals("Let the Force be with you"))
            {
                int[] jediCoordinates = Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt).toArray();

                int[] evilForceCoordinates = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

                int evilForceRow = evilForceCoordinates[0];
                int evilForceCol = evilForceCoordinates[1];

                EvilForce evilForce = new EvilForce(evilForceRow, evilForceCol);
                evilForce.destroyGalaxy(galaxy);

                int jediRow = jediCoordinates[0];
                int jediCol = jediCoordinates[1];

                Jedi jedi = new Jedi(jediRow, jediCol);
                starCount += jedi.getStarsSum(galaxy);

                command = scanner.nextLine();
            }
        System.out.println(starCount);
    }
}
