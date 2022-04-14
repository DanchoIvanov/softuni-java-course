package glacial_expedition.models.mission;

import glacial_expedition.models.explorers.Explorer;
import glacial_expedition.models.states.State;

import java.util.ArrayList;
import java.util.Collection;

public class MissionImpl implements Mission {

    @Override
    public void explore(State state, Collection<Explorer> explorers) {
        ArrayList<String> exhibits = new ArrayList<>(state.getExhibits());
        for (Explorer explorer : explorers){
            while (explorer.canSearch() && !exhibits.isEmpty()){
                explorer.search();
                explorer.getSuitcase().getExhibits().add(exhibits.remove(0));
            }
        }
    }
}
