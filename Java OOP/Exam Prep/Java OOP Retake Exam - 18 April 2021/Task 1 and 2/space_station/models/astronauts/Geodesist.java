package space_station.models.astronauts;

public class Geodesist extends BaseAstronaut {

    private final static double OXYGEN = 50;

    public Geodesist(String name) {
        super(name, OXYGEN);
    }
}
