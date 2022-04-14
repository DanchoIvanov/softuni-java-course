import java.util.Scanner;

public class ExcursionGames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int players = Integer.parseInt(scanner.nextLine());
        int number = 0;
        int winnersCount = 0;
        int losersCount = 0;

        for (int i = 1; i <= players ; i++) {
            int total = 0;
            String destination = scanner.nextLine();
            for (int j = 0; j < destination.length() ; j++) {
                number = Integer.parseInt(scanner.nextLine());
                total += number;
            }
            if (total % destination.length() == 0){
                System.out.println("Win");
                winnersCount++;
            }
            else{
                System.out.println("Lost");
                losersCount++;
            }
        }
        double winnersPercentage = (winnersCount *1.0 / players) * 100;
        double losersPercentage = (losersCount * 1.0 / players) * 100;

        System.out.printf("Win: %.2f%%%n",winnersPercentage);
        System.out.printf("Lost: %.2f%%%n",losersPercentage);
    }
}
