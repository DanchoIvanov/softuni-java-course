package car_info;

public class Car {

    private String brand;
    private String model;
    private int horsepower;

    public Car () {

    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getHorsepower() {
        return horsepower;
    }

    @Override
    public String toString(){
        return String.format("The car is: %s %s - %d HP.",this.brand, this.model, this.horsepower);
    }
}
