import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int lostGamesCount = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        int headsetTrashes = lostGamesCount/2;
        int mouseTrashes = lostGamesCount/3;
        int keyboardTrashes = lostGamesCount/6;
        int displayTrashes = lostGamesCount/12;

        double totalPrice = headsetPrice * headsetTrashes + mousePrice * mouseTrashes + keyboardPrice * keyboardTrashes + displayPrice * displayTrashes;

        System.out.printf("Rage expenses: %.2f lv.",totalPrice);
    }
}
