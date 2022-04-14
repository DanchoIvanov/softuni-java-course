import java.util.Scanner;

public class BackToThePast {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double legacy = Double.parseDouble(scanner.nextLine());
        int yearToLiveTo = Integer.parseInt(scanner.nextLine());
        int yearsToLive = yearToLiveTo - 1799;
        double moneyNeeded = 0;

        for (int i = 0; i < yearsToLive; i++) {
            if (i%2==0){
                moneyNeeded += 12000;
            }
            else {
                moneyNeeded += 12000 + 50*(18+i);
            }
        }

        double difference = Math.abs(moneyNeeded - legacy);

        if (legacy >= moneyNeeded){
            System.out.printf("Yes! He will live a carefree life and will have %.2f dollars left.",difference);
        }
        else
            System.out.printf("He will need %.2f dollars to survive.",difference);
    }
}
