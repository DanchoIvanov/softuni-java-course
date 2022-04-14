package barracks_wars;

import barracks_wars.interfaces.Repository;
import barracks_wars.interfaces.Runnable;
import barracks_wars.interfaces.UnitFactory;
import barracks_wars.core.Engine;
import barracks_wars.core.factories.UnitFactoryImpl;
import barracks_wars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
