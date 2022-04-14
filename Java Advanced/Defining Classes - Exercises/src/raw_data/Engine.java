package raw_data;

public class Engine {

    private int speed;
    private int horsePower;

    public Engine(int speed, int horsePower) {
        this.speed = speed;
        this.horsePower = horsePower;
    }

    public int getHorsePower() {
        return horsePower;
    }
}
