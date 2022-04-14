package space_station.models.mission;

import space_station.models.astronauts.Astronaut;
import space_station.models.planets.Planet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MissionImpl implements Mission {
    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {

        List<String> planetItems = new ArrayList<>(planet.getItems());

        for (Astronaut astronaut : astronauts){
            while (!planetItems.isEmpty() && astronaut.canBreath()){
                astronaut.breath();
                astronaut.getBag().getItems().add(planetItems.remove(0));
            }
        }
    }
}
