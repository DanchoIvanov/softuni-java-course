import java.util.Scanner;

public class GameOfIntervals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int turns = Integer.parseInt(scanner.nextLine());
        int to10Count =0;
        int to20Count =0;
        int to30Count =0;
        int to40Count =0;
        int to50Count =0;
        int invalidCount = 0;
        double totalPoints = 0;

        for (int i = 1; i <=turns ; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            if (number < 0 || number > 50){
                totalPoints = totalPoints * 1.0 / 2;
                invalidCount++;
            }
            else if (number < 10){
                totalPoints += 0.2 * number;
                to10Count++;
            }
            else if (number < 20){
                totalPoints += 0.3 * number;
                to20Count++;
            }
            else if (number < 30){
                totalPoints += 0.4 * number;
                to30Count++;
            }
            else if (number < 40){
                totalPoints += 50;
                to40Count++;
            }
            else if (number <= 50){
                totalPoints += 100;
                to50Count++;
            }
        }
        double to10Percentage = (to10Count*1.0/turns)*100;
        double to20Percentage = (to20Count*1.0/turns)*100;
        double to30Percentage = (to30Count*1.0/turns)*100;
        double to40Percentage = (to40Count*1.0/turns)*100;
        double to50Percentage = (to50Count*1.0/turns)*100;
        double invalidPercentage = (invalidCount*1.0/turns)*100;

        System.out.printf("%.2f%n",totalPoints);
        System.out.printf("From 0 to 9: %.2f%%%n", to10Percentage);
        System.out.printf("From 10 to 19: %.2f%%%n", to20Percentage);
        System.out.printf("From 20 to 29: %.2f%%%n", to30Percentage);
        System.out.printf("From 30 to 39: %.2f%%%n", to40Percentage);
        System.out.printf("From 40 to 50: %.2f%%%n", to50Percentage);
        System.out.printf("Invalid numbers: %.2f%%%n", invalidPercentage);
    }
}
