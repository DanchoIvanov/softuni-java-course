import java.util.Scanner;

public class BikeRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int juniors = Integer.parseInt(scanner.nextLine());
        int seniors = Integer.parseInt(scanner.nextLine());
        String trackType = scanner.nextLine();

        double taxJuniors = 0;
        double taxSeniors = 0;

        if (trackType.equals("trail")){
            taxJuniors = 5.5;
            taxSeniors = 7;
        }
        else if (trackType.equals("cross-country")){
            taxJuniors = 8;
            taxSeniors = 9.5;
            if (juniors + seniors >= 50){
                taxJuniors = 8 * 0.75;
                taxSeniors = 9.5 * 0.75;
            }

        }
        else if (trackType.equals("downhill")){
            taxJuniors = 12.25;
            taxSeniors = 13.75;
        }
        else if (trackType.equals("road")){
            taxJuniors = 20;
            taxSeniors = 21.5;
        }

        double collectedSum = juniors * taxJuniors + seniors * taxSeniors;
        double charity = collectedSum * 0.95;

        System.out.printf("%.2f",charity);
    }
}
