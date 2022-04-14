package barracks_wars.core.factories;

import barracks_wars.interfaces.Unit;
import barracks_wars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException {
		try {
			String className = "barracksWars.models.units." + unitType;
			Class <Unit> unit = (Class<Unit>) Class.forName(className);
			Constructor<Unit> constructor = unit.getConstructor();
			return constructor.newInstance();
		} catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException ex) {
			throw new ExecutionControl.NotImplementedException(ex.getMessage());
		}
	}
}
