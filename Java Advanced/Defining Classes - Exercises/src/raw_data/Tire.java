package raw_data;

public class Tire {

    private double airPressure;
    private int age;

    public Tire(double airPressure, int age) {
        this.airPressure = airPressure;
        this.age = age;
    }

    public double getAirPressure() {
        return airPressure;
    }
}
