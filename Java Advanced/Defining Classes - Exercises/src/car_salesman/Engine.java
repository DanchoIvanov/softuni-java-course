package car_salesman;

public class Engine {

    private String model;
    private int horsePower;
    private int displacement;
    private String efficiency;

    public Engine(String model, int horsePower) {
        this.model = model;
        this.horsePower = horsePower;
    }

    public Engine(String model, int horsePower, int displacement) {
        this(model, horsePower);
        this.displacement = displacement;
    }

    public Engine(String model, int horsePower, String efficiency) {
        this(model, horsePower);
        this.efficiency = efficiency;
    }

    public Engine(String model, int horsePower, int displacement, String efficiency) {
        this(model, horsePower, displacement);
        this.efficiency = efficiency;
    }

    public String getModel() {
        return model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public int getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        if (efficiency == null){
            return "n/a";
        }
        return efficiency;
    }
}
