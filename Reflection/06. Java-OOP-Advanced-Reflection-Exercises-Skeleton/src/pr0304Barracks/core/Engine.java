package pr0304Barracks.core;

import pr0304Barracks.contracts.*;
import pr0304Barracks.contracts.Runnable;
import pr0304Barracks.io.abstractions.Reader;
import pr0304Barracks.io.abstractions.Writer;

import java.io.IOException;

public class Engine implements Runnable {

	private CommandInterpreter commandInterpreter;
	private Reader reader;
	private Writer writer;

	public Engine(CommandInterpreter commandInterpreter, Reader reader, Writer writer) {
		this.commandInterpreter = commandInterpreter;
		this.reader = reader;
		this.writer = writer;
	}

	@Override
	public void run() {

		while (true) {
			try {
				String input = reader.readLine();
				String[] data = input.split("\\s+");

				Executable command = commandInterpreter.interpretCommand(data);
				String result = command.execute();
				if (result.equals("fight")) {
					break;
				}

				writer.writeLine(result);
			} catch (RuntimeException e) {
				writer.writeLine(e.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
