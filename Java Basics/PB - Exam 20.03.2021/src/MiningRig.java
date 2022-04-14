import java.util.Scanner;

public class MiningRig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int graphicsCard = Integer.parseInt(scanner.nextLine());
        int adapter = Integer.parseInt(scanner.nextLine());
        double cardConsumption = Double.parseDouble(scanner.nextLine());
        double turnoverPerCardPerDay = Double.parseDouble(scanner.nextLine());

        int rigPrice = 13 * (graphicsCard + adapter) + 1000;
        double profitPerCardPerDay = turnoverPerCardPerDay - cardConsumption;
        double investmentReturn = Math.ceil(rigPrice/(profitPerCardPerDay*13));

        System.out.println(rigPrice);
        System.out.printf("%.0f", investmentReturn);
    }
}
