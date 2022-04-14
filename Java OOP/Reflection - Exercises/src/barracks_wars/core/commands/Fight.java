package barracks_wars.core.commands;

import barracks_wars.interfaces.Repository;
import barracks_wars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

public class Fight extends Command {
    public Fight(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException {
        return "fight";
    }
}
