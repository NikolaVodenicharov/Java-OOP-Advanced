package io.concreteClasses;

import io.abstractions.Reader;

import java.io.BufferedReader;
import java.io.IOException;

public class ConsoleReaderLine implements Reader {

    private BufferedReader bufferedReader;

    public ConsoleReaderLine(BufferedReader bufferedReader){
        this.bufferedReader = bufferedReader;
    }

    @Override
    public String read() throws IOException {
        String line = bufferedReader.readLine();
        return line;
    }
}
