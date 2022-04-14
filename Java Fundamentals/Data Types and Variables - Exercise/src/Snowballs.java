import java.util.Scanner;

public class Snowballs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int currentSnowballSnow = 0;
        int currentSnowballTime = 0;
        int currentSnowballQuality = 0;
        double maxSnowballValue = -Double.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());
            double snowballValue = Math.pow((snowballSnow*1.0 / snowballTime),  snowballQuality);
            if (snowballValue > maxSnowballValue){
                maxSnowballValue=snowballValue;
                currentSnowballSnow = snowballSnow;
                currentSnowballTime = snowballTime;
                currentSnowballQuality = snowballQuality;
            }
        }
        System.out.printf("%d : %d = %.0f (%d)",currentSnowballSnow,currentSnowballTime,maxSnowballValue,currentSnowballQuality);
    }
}
