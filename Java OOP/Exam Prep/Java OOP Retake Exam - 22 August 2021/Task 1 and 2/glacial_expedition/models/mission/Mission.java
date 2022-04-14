package glacial_expedition.models.mission;

import glacial_expedition.models.explorers.Explorer;
import glacial_expedition.models.states.State;


import java.util.Collection;

public interface Mission {
    void explore(State state, Collection<Explorer> explorers);
}
