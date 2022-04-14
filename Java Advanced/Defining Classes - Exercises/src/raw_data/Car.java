package raw_data;

import java.util.ArrayList;
import java.util.List;

public class Car {


    private String model;
    private Engine engine;
    private Cargo cargo;
    private List<Tire> tires = new ArrayList<>();

    public Car(String model, Engine engine, Cargo cargo, List<Tire> tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public Engine getEngine() {
        return engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public String getModel() {
        return model;
    }

    public List<Tire> getTires() {
        return tires;
    }
}
