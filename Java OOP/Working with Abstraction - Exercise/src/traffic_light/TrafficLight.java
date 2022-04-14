package traffic_light;

public enum TrafficLight {
    RED,
    GREEN,
    YELLOW;

    public static TrafficLight change(TrafficLight color){
        switch (color){
            case RED:
                return GREEN;
            case GREEN:
                return YELLOW;
            case YELLOW:
                return RED;
            default:
                throw new IllegalArgumentException("Color " + color + "does not exist in the traffic light!");
        }
    }
}
