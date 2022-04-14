package _05;

public enum CardType {
    STANDARD("Standard"), SILVER("Silver"), GOLD("Gold"), PLATINUM("Platinum"), DIAMOND("Diamond");

    private String type;

    CardType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
