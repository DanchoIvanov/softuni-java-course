import java.util.Scanner;

public class BirthdayParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hallRent = Integer.parseInt(scanner.nextLine());
        double cakePrice = hallRent * 0.2;
        double drinksPrice = cakePrice * 0.55;
        double animatorPrice = hallRent / 3.0;
        double sum = hallRent + cakePrice + drinksPrice + animatorPrice;

        System.out.println(sum);

    }
}
