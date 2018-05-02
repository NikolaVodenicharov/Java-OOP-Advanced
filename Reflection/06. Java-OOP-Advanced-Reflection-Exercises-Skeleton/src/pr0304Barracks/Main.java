package pr0304Barracks;

import pr0304Barracks.contracts.*;
import pr0304Barracks.contracts.Runnable;
import pr0304Barracks.core.CommandInterpreterImpl;
import pr0304Barracks.core.Engine;
import pr0304Barracks.core.factories.CommandFactoryImpl;
import pr0304Barracks.core.factories.UnitFactoryImpl;
import pr0304Barracks.data.UnitRepository;
import pr0304Barracks.io.abstractions.Reader;
import pr0304Barracks.io.abstractions.Writer;
import pr0304Barracks.io.concreteClasses.ConsoleReader;
import pr0304Barracks.io.concreteClasses.ConsoleWriter;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
		Repository repository = new UnitRepository();
		UnitFactory unitFactory = new UnitFactoryImpl();

        CommandFactory commandFactory = new CommandFactoryImpl(repository, unitFactory);

        CommandInterpreter commandInterpreter = new CommandInterpreterImpl(commandFactory);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Reader reader = new ConsoleReader(bufferedReader);
        Writer writer = new ConsoleWriter();

        Runnable engine = new Engine(commandInterpreter, reader, writer);

		engine.run();
	}
}
