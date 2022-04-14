package hotel_reservation;

public enum DiscountType {

    VIP(0.2),
    SECOND_VISIT(0.1),
    NONE(0);

    private double value;

    DiscountType(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public static DiscountType stringValueOf(String discountType) {
        switch (discountType) {
            case "VIP":
                return VIP;
            case "SecondVisit":
                return SECOND_VISIT;
            case "None":
                return NONE;
            default:
                throw new IllegalArgumentException("No such discount type: " + discountType);
        }
    }
}

