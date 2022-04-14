package space_station;

import space_station.core.Controller;
import space_station.core.ControllerImpl;
import space_station.core.Engine;
import space_station.core.EngineImpl;

public class Main {

    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
