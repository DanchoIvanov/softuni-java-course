package barracks_wars.core.commands;

import barracks_wars.interfaces.Repository;
import barracks_wars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

public class Retire extends Command {
    public Retire(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException {
        try {
            String unitType = getData()[1];
            getRepository().removeUnit(unitType);
            String output = unitType + " retired!";
            return output;
        } catch (ExecutionControl.NotImplementedException e) {
            return e.getMessage();
        }
    }
}
