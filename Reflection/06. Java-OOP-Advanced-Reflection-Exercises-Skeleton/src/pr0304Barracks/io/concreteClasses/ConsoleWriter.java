package pr0304Barracks.io.concreteClasses;

import pr0304Barracks.io.abstractions.Writer;

public class ConsoleWriter implements Writer {
    @Override
    public void writeLine(String text) {
        System.out.println(text);
    }
}
