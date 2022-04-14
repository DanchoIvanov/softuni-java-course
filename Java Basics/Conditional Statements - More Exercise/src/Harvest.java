import java.util.Scanner;

public class Harvest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int vineyardArea = Integer.parseInt(scanner.nextLine());
        double grapesForSqMeter = Double.parseDouble(scanner.nextLine());
        int requiredLittersWine = Integer.parseInt(scanner.nextLine());
        int workers = Integer.parseInt(scanner.nextLine());

        double totalGrape = vineyardArea*grapesForSqMeter;
        double wineMade = 0.4*totalGrape/2.5;
        double difference = Math.abs(wineMade-requiredLittersWine);

        if (wineMade >= requiredLittersWine){
            double winePerWorker = difference/workers;
            System.out.printf("Good harvest this year! Total wine: %.0f liters.%n%.0f liters left -> %.0f liters per person.",Math.floor(wineMade),Math.ceil(difference),Math.ceil(winePerWorker));
        }

        else
            System.out.printf("It will be a tough winter! More %.0f liters wine needed.",Math.floor(difference));
    }
}
