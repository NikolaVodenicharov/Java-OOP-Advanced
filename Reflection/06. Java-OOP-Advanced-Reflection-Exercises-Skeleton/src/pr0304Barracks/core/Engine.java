package pr0304Barracks.core;

import pr0304Barracks.contracts.*;
import pr0304Barracks.contracts.Runnable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine implements Runnable {

	//private Repository repository;
	//private UnitFactory unitFactory;
	//private CommandFactory commandFactory;
	private CommandInterpreter commandInterpreter;

	public Engine(CommandInterpreter commandInterpreter) {

		//this.repository = repository;
		//this.unitFactory = unitFactory;
		//this.commandFactory = commandFactory;
		this.commandInterpreter = commandInterpreter;
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			try {
				String input = reader.readLine();
				String[] data = input.split("\\s+");

				Executable command = commandInterpreter.interpretCommand(data);
				String result = command.execute();
				if (result.equals("fight")) {
					break;
				}

				System.out.println(result);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
