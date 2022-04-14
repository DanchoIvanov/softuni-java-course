import java.util.Scanner;

public class FootballLeague {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int capacity = Integer.parseInt(scanner.nextLine());
        int fans = Integer.parseInt(scanner.nextLine());
        int aCount = 0;
        int bCount = 0;
        int vCount = 0;
        int gCount = 0;

        for (int i = 1; i <= fans ; i++) {
            String input = scanner.nextLine();
            switch (input){
                case("A"):
                    aCount++;
                    break;
                case("B"):
                    bCount++;
                    break;
                case("V"):
                    vCount++;
                    break;
                case("G"):
                    gCount++;
                    break;
            }
        }
        double aPercentage = (aCount*1.0/fans)*100;
        double bPercentage = (bCount*1.0/fans)*100;
        double vPercentage = (vCount*1.0/fans)*100;
        double gPercentage = (gCount*1.0/fans)*100;
        double occupationPercentage = (fans*1.0/capacity)*100;

        System.out.printf("%.2f%%%n", aPercentage);
        System.out.printf("%.2f%%%n", bPercentage);
        System.out.printf("%.2f%%%n", vPercentage);
        System.out.printf("%.2f%%%n", gPercentage);
        System.out.printf("%.2f%%%n", occupationPercentage);
    }
}
