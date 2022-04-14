package _05;

import javax.persistence.*;

@Entity
@Table(name = "credit_cards")
public class CreditCard extends BillingDetail {

    @Column(name = "card_type", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private CardType cardType;

    @Column(name = "expiration_month", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Month expirationMonth;

    @Column(name = "expiration_year", nullable = false)
    private int expirationYear;

    public CreditCard() {
        super();
    }

    public CreditCard(String owner, String number, CardType cardType, Month month, int year) {
        super(owner, number);
        this.cardType = cardType;
        this.expirationMonth = month;
        this.expirationYear = year;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public Month getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(Month expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public int getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(int expirationYear) {
        this.expirationYear = expirationYear;
    }
}
