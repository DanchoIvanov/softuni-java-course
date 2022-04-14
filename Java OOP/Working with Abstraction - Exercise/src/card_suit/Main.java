package card_suit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        switch (input){
            case "Card Suits":
                System.out.println("Card Suits:");
                for (CardSuit card : CardSuit.values()) {
                    System.out.printf("Ordinal value: %d; Name value: %s%n", card.ordinal(), card);
                }
                break;
            case "Card Ranks":
                System.out.println("Card Ranks:");
                for (CardType card : CardType.values()) {
                    System.out.printf("Ordinal value: %d; Name value: %s%n", card.ordinal(), card);
                }
                break;
            default:
                String cardName = input;
                String cardSuit = scanner.nextLine();
                System.out.println(new Card(CardType.valueOf(cardName), CardSuit.valueOf(cardSuit)));
        }
    }
}
