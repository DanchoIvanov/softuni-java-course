package hotel_reservation;

public class PriceCalculator {
    private double pricePerDay;
    private int numberOfDays;
    private Seasons season;
    private DiscountType discountType;

    public PriceCalculator(double pricePerDay, int numberOfDays, String season, String discountType) {
        this.pricePerDay = pricePerDay;
        this.numberOfDays = numberOfDays;
        this.season = Seasons.stringValueOf(season);
        this.discountType = DiscountType.stringValueOf(discountType);
    }

    public double calculatePrice(){
       return this.pricePerDay * this.numberOfDays * this.season.getValue() * (1 - this.discountType.getValue());
    }

}
