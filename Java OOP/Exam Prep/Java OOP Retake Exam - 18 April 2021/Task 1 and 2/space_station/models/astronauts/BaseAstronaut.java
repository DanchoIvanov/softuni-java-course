package space_station.models.astronauts;

import space_station.common.ExceptionMessages;
import space_station.models.bags.Backpack;
import space_station.models.bags.Bag;

public abstract class BaseAstronaut implements Astronaut {

    private String name;
    private double oxygen;
    private Bag bag;

    private void setName(String name) {
        if (name.trim().equals("")){
            throw new NullPointerException(ExceptionMessages.ASTRONAUT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setOxygen(double oxygen) {
        if (oxygen < 0){
            throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_OXYGEN_LESS_THAN_ZERO);
        }
        this.oxygen = oxygen;
    }

    protected BaseAstronaut(String name, double oxygen) {
        this.setName(name);
        this.setOxygen(oxygen);
        this.bag = new Backpack();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getOxygen() {
        return this.oxygen;
    }

    @Override
    public Bag getBag() {
        return this.bag;
    }

    @Override
    public void breath() {
        if (getOxygen() < 10){
            setOxygen(0);
        } else {
            setOxygen(getOxygen() - 10);
        }
    }

    @Override
    public boolean canBreath() {
        return oxygen > 0;
    }
}
