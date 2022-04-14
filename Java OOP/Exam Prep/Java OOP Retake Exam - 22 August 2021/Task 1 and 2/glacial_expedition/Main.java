package glacial_expedition;

import glacial_expedition.core.Controller;
import glacial_expedition.core.ControllerImpl;
import glacial_expedition.core.Engine;
import glacial_expedition.core.EngineImpl;

public class Main {

    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
