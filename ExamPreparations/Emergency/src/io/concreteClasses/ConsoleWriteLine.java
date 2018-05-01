package io.concreteClasses;

import io.abstractions.Writer;

public class ConsoleWriteLine implements Writer {
    @Override
    public void write(String text) {
        System.out.println(text);
    }
}
