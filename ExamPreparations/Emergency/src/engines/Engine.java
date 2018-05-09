package engines;

import commands.Executable;
import interpreters.Interpreter;
import io.Reader;
import io.Writer;

import java.io.IOException;

public class Engine implements Runnable {
    private static final String BREAK_COMMAND = "EmergencyBreak";

    private Interpreter interpreter;
    private Writer writer;
    private Reader reader;

    public Engine(Interpreter interpreter, Writer writer, Reader reader) {
        this.interpreter = interpreter;
        this.writer = writer;
        this.reader = reader;
    }

    @Override
    public void run() throws IOException {
        while(true){
            String line = this.reader.read();

            if (BREAK_COMMAND.equals(line)){
                break;
            }

            String[] arguments = line.split("[|]+");
            Executable command = this.interpreter.interpret(arguments);
            String result = command.execute();
            this.writer.write(result);
        }
    }
}
