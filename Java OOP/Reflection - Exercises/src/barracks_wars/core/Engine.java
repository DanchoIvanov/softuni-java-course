package barracks_wars.core;

import barracks_wars.core.commands.Command;
import barracks_wars.interfaces.Repository;
import barracks_wars.interfaces.Runnable;
import barracks_wars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {

	private Repository repository;
	private UnitFactory unitFactory;

	public Engine(Repository repository, UnitFactory unitFactory) {
		this.repository = repository;
		this.unitFactory = unitFactory;
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		while (true) {
			try {
				String input = reader.readLine();
				String[] data = input.split("\\s+");
				String commandName = data[0];
				String result = interpretCommand(data, commandName);
				if (result.equals("fight")) {
					break;
				}
				System.out.println(result);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			} catch (IOException | ExecutionControl.NotImplementedException e) {
				e.printStackTrace();
			}
		}
	}

	// TODO: refactor for problem 4
	private String interpretCommand(String[] data, String commandName) throws ExecutionControl.NotImplementedException {
		try	{
			commandName = convertToTitleCase(commandName);
			String className = "barracksWars.core.commands." + commandName;
			Class<Command> command = (Class<Command>) Class.forName(className);
			Constructor<Command> constructor = command.getConstructor(String[].class, Repository.class, UnitFactory.class);
			 return constructor.newInstance(data, repository, unitFactory).execute();
		} catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e){
			throw new RuntimeException("Invalid command!");
		}
	}

	private String convertToTitleCase(String commandName) {
		return commandName.substring(0, 1).toUpperCase() + commandName.substring(1);
	}
}
