package card_suit;

public class Card {
    private CardType cardType;
    private CardSuit cardSuit;

    public Card(CardType cardType, CardSuit cardSuit) {
        this.cardType = cardType;
        this.cardSuit = cardSuit;
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d",cardType, cardSuit, cardType.getPower() + cardSuit.getPower());
    }
}
