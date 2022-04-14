import java.util.Scanner;

public class WorldSwimmingRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double recordTime = Double.parseDouble(scanner.nextLine());
        double length = Double.parseDouble(scanner.nextLine());
        double speed = Double.parseDouble(scanner.nextLine());

        double waterResistance = Math.floor(length/15);
        double waterResistanceTimeLoss = waterResistance*12.5;
        double time = length*speed + waterResistanceTimeLoss;
        double difference = time - recordTime;

        if (time<recordTime){
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.",time);
        }
        else
            System.out.printf("No, he failed! He was %.2f seconds slower.",difference);
    }
}
