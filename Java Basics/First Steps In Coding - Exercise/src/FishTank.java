import java.util.Scanner;

public class FishTank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());
        int width = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());
        double sandQuantityPercentage = Double.parseDouble(scanner.nextLine());

        int cubicalArea = length * width * height;
        double waterNeededToFillTheThank = cubicalArea * 0.001;
        double waterNeeded = waterNeededToFillTheThank * (1 - sandQuantityPercentage * 0.01);

        System.out.printf("%.2f",waterNeeded);


    }
}
