package io.concreteClasses;

import io.abstractions.Reader;

import java.io.BufferedReader;
import java.io.IOException;

public class ConsoleReader implements Reader {

    private BufferedReader bufferedReader;

    public ConsoleReader(BufferedReader bufferedReader){
        this.bufferedReader = bufferedReader;
    }

    @Override
    public String readLine() throws IOException {
        String line = bufferedReader.readLine();
        return line;
    }
}
