package cat_house;

import cat_house.core.Engine;
import cat_house.core.EngineImpl;

public class Main {
    public static void main(String[] args) {

        Engine engine = new EngineImpl();
        engine.run();
    }
}
