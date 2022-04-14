import java.util.Arrays;
import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = new int[15][15];
        int[] playersCoordinates = {7, 7, 0};
        int playerHitPoints = 18500;
        double bossHitPoints = 3000000;

        double damagePerRound = Double.parseDouble(scanner.nextLine());
        boolean cloudEffect = false;
        String spell = "";

        while(playerHitPoints > 0 && bossHitPoints >0){
            bossHitPoints -= damagePerRound;
            if (cloudEffect){
                playerHitPoints -= 3500;
                cloudEffect = false;
                if (playerHitPoints <= 0){
                    break;
                }
            }
            if (bossHitPoints > 0){
                String input = scanner.nextLine();
                spell = input.split("\\s+")[0];
                int row = Integer.parseInt(input.split("\\s+")[1]);
                int col = Integer.parseInt(input.split("\\s+")[2]);

                hitTheMatrix(row ,col, matrix);
                playersCoordinates = getPlayersCoordinates(playersCoordinates, matrix);

                if (playersCoordinates[2] == 1){
                    switch (spell){
                        case "Cloud":
                            spell = "Plague Cloud";
                            playerHitPoints -= 3500;
                            cloudEffect = true;
                            break;
                        case "Eruption":
                            playerHitPoints -= 6000;
                            break;
                    }
                }
            }
            matrix = new int[15][15];
        }
        if (bossHitPoints <=0){
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f%n",bossHitPoints);
        }

        if (playerHitPoints <= 0){
            System.out.println("Player: Killed by " + spell);
        } else {
            System.out.println("Player: " + playerHitPoints);
        }
        int row = playersCoordinates [0];
        int col = playersCoordinates [1];
        System.out.printf("Final position: %d, %d", row, col);
    }

    private static int[] getPlayersCoordinates(int[] playersCoordinates, int[][] matrix) {
        int[] arr = Arrays.copyOf(playersCoordinates, playersCoordinates.length);
        int row = arr[0];
        int col = arr[1];

        if (matrix[row][col] == 1){
            arr[2] = 1;
            if (row -1 >= 0){ //up
                if (matrix[row - 1][col] == 0) {
                    arr [0] = row - 1;
                    arr[2] = 0;
                    return arr;
                }
            }
            if (col + 1 < matrix.length){ // right
                if (matrix[row][col + 1] == 0) {
                    arr [1] = col + 1;
                    arr[2] = 0;
                    return arr;
                }
            }
            if (row + 1 < matrix.length){ // down
                if (matrix[row + 1][col] == 0) {
                    arr [0] = row + 1;
                    arr[2] = 0;
                    return arr;
                }
            }
            if (col - 1 >= 0){ // left
                if (matrix[row][col - 1] == 0) {
                    arr [1] = col - 1;
                    arr[2] = 0;
                    return arr;
                }
            }
        }
        return arr;
    }

    private static void hitTheMatrix(int row, int col, int[][] matrix) {
        if (row + 1 >= 0 && row -1 < 15 && col + 1 >= 0 && col - 1 < 15){
            if (row -1 >= 0){
                if (col - 1 >= 0){
                    matrix[row -1][col -1] = 1;
                }
                if (col >= 0 && col <15){
                    matrix[row -1][col] = 1;
                }
                if (col + 1 < 15){
                    matrix[row -1][col + 1] = 1;
                }
            }
            if (row >= 0 && row < 15){
                if (col - 1 >= 0){
                    matrix[row][col -1] = 1;
                }
                if (col >= 0 && col <15){
                    matrix[row][col] = 1;
                }
                if (col + 1 < 15){
                    matrix[row][col + 1] = 1;
                }
            }
            if (row + 1 <15) {
                if (col - 1 >= 0) {
                    matrix[row + 1][col - 1] = 1;
                }
                if (col >= 0 && col < 15) {
                    matrix[row + 1][col] = 1;
                }
                if (col + 1 < 15) {
                    matrix[row + 1][col + 1] = 1;
                }
            }
        }
    }
}