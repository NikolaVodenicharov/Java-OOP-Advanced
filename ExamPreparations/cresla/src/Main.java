import core.Engine;
import core.Runnable;
import io.ConsoleReader;
import io.ConsoleWriter;
import io.InputReader;
import io.OutputWriter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        InputReader reader = new ConsoleReader();
        OutputWriter writer = new ConsoleWriter();
        Runnable engine = new Engine(reader, writer);

        engine.run();
    }
}
