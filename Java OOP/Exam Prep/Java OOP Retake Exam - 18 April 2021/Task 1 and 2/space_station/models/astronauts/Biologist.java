package space_station.models.astronauts;

public class Biologist extends BaseAstronaut {

    private final static double OXYGEN = 70;

    public Biologist(String name) {
        super(name, OXYGEN);
    }

    @Override
    public void breath() {
        if (getOxygen() < 5){
            this.setOxygen(0);
        } else {
            this.setOxygen(getOxygen() - 5);
        }
    }
}
