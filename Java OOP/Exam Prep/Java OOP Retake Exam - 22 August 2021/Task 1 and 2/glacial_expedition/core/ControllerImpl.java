package glacial_expedition.core;

import glacial_expedition.common.ConstantMessages;
import glacial_expedition.common.ExceptionMessages;
import glacial_expedition.models.explorers.AnimalExplorer;
import glacial_expedition.models.explorers.Explorer;
import glacial_expedition.models.explorers.GlacierExplorer;
import glacial_expedition.models.explorers.NaturalExplorer;
import glacial_expedition.models.mission.Mission;
import glacial_expedition.models.mission.MissionImpl;
import glacial_expedition.models.states.State;
import glacial_expedition.models.states.StateImpl;
import glacial_expedition.repositories.ExplorerRepository;
import glacial_expedition.repositories.StateRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private ExplorerRepository explores;
    private StateRepository states;
    private int exploredStatesCount;

    @Override
    public String addExplorer(String type, String explorerName) {
        Explorer explorer;
        switch (type){
            case "NaturalExplorer":
                explorer = new NaturalExplorer(explorerName);
                break;
            case "GlacierExplorer":
                explorer = new GlacierExplorer(explorerName);
                break;
            case "AnimalExplorer":
                explorer = new AnimalExplorer(explorerName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.EXPLORER_INVALID_TYPE);
        }
        explores.add(explorer);

        return String.format(ConstantMessages.EXPLORER_ADDED, type, explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {
        State state = new StateImpl(stateName);
        Arrays.stream(exhibits).forEach(e -> state.getExhibits().add(e));
        states.add(state);
        return String.format(ConstantMessages.STATE_ADDED, stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {
        Explorer explorer = explores.byName(explorerName);
        if (explorer == null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.EXPLORER_DOES_NOT_EXIST, explorerName));
        }
        return String.format(ConstantMessages.EXPLORER_RETIRED, explorerName);
    }

    @Override
    public String exploreState(String stateName) {
        State state = states.byName(stateName);
        List<Explorer> suitableExplorers = new ArrayList<>();
        suitableExplorers = explores.getCollection().stream().filter(e -> e.getEnergy() > 50).collect(Collectors.toList());
        if (suitableExplorers.isEmpty()){
            throw new IllegalArgumentException(ExceptionMessages.STATE_EXPLORERS_DOES_NOT_EXISTS);
        }
        Mission mission = new MissionImpl();
        mission.explore(state, suitableExplorers);
        long retiredExplorers = suitableExplorers.stream().filter(e-> e.getEnergy() == 0).count();
        this.exploredStatesCount ++;
        return String.format(ConstantMessages.STATE_EXPLORER, stateName, retiredExplorers);
    }

    @Override
    public String finalResult() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(ConstantMessages.FINAL_STATE_EXPLORED, this.exploredStatesCount))
                .append(System.lineSeparator())
                .append(ConstantMessages.FINAL_EXPLORER_INFO);
        for (Explorer explorer : explores.getCollection()){
            sb.append(System.lineSeparator())
                    .append(String.format(ConstantMessages.FINAL_EXPLORER_NAME, explorer.getName()))
                    .append(System.lineSeparator())
                    .append(String.format(ConstantMessages.FINAL_EXPLORER_ENERGY, explorer.getEnergy()))
                    .append(System.lineSeparator());
            if(explorer.getSuitcase().getExhibits().isEmpty()){
                sb.append(String.format(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS, "None"));
            } else {
                sb.append(String.format(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS,
                        String.join(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER, explorer.getSuitcase().getExhibits())));
            }
        }
        return sb.toString();
    }

    public ControllerImpl() {
        this.explores = new ExplorerRepository();
        this.states = new StateRepository();
        this.exploredStatesCount = 0;
    }
}
