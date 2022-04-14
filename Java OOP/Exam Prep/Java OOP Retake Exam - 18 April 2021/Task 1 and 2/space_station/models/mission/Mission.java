package space_station.models.mission;

import space_station.models.astronauts.Astronaut;
import space_station.models.planets.Planet;

import java.util.Collection;

public interface Mission {
    void explore(Planet planet, Collection<Astronaut> astronauts);
}
