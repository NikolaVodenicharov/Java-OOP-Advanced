package core.managers;

import core.commands.Executable;
import io.Reader;
import io.Writer;

import java.io.IOException;

public class Engine implements Runnable{
    private static final String BREAK_COMMAND = "EmergencyBreak";

    private CommandInterpreter commandInterpreter;
    private Writer writer;
    private Reader reader;

    public Engine( CommandInterpreter commandInterpreter, Writer writer, Reader reader) {
        this.commandInterpreter = commandInterpreter;
        this.writer = writer;
        this.reader = reader;
    }

    @Override
    public void run() throws IOException {
        while(true){
            String line = this.reader.readLine();

            if (BREAK_COMMAND.equals(line)){
                break;
            }

            String[] arguments = line.split("[|]+");
            Executable command = this.commandInterpreter.interpret(arguments);
            String result = command.execute();
            this.writer.writeLine(result);
        }
    }
}
