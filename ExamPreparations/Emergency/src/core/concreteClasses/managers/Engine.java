package core.concreteClasses.managers;

import core.abstractions.CommandInterpreter;
import core.abstractions.Executable;
import core.abstractions.Runnable;
import io.Reader;
import io.Writer;

import java.io.IOException;

public class Engine implements Runnable{
    private static final String BREAK_COMMAND = "EmergencyBreak";

    private CommandInterpreter commandInterpreter;
    private Writer writer;
    private Reader reader;

    public Engine(CommandInterpreter commandInterpreter, Writer writer, Reader reader) {
        this.commandInterpreter = commandInterpreter;
        this.writer = writer;
        this.reader = reader;
    }

    @Override
    public void run() throws IOException {
        while(true){
            String line = this.reader.readLine();
            String[] splitLine = line.split("|");
            
            String commandName = splitLine[0];

            boolean isBreak = BREAK_COMMAND.equals(commandName);
            if (isBreak){
                break;
            }

            Executable command = this.commandInterpreter.interpret(commandName);

            String result = command.execute();

            this.writer.writeLine(result);
        }
    }
}
