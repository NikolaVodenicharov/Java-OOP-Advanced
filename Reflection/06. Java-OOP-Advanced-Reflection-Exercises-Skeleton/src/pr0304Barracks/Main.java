package pr0304Barracks;

import pr0304Barracks.contracts.*;
import pr0304Barracks.contracts.Runnable;
import pr0304Barracks.core.CommandInterpreterImpl;
import pr0304Barracks.core.Engine;
import pr0304Barracks.core.factories.CommandFactoryImpl;
import pr0304Barracks.core.factories.UnitFactoryImpl;
import pr0304Barracks.data.UnitRepository;

import java.lang.reflect.Constructor;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
		Repository repository = new UnitRepository();
		UnitFactory unitFactory = new UnitFactoryImpl();

        CommandFactory commandFactory = new CommandFactoryImpl(repository, unitFactory);

        CommandInterpreter commandInterpreter = new CommandInterpreterImpl(commandFactory);

        Runnable engine = new Engine(commandInterpreter);

		engine.run();
	}
}
