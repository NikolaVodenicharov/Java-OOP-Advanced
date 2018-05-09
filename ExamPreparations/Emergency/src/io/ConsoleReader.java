package io;

import java.io.BufferedReader;
import java.io.IOException;

public class ConsoleReader implements Reader {

    private BufferedReader bufferedReader;

    public ConsoleReader(BufferedReader bufferedReader){
        this.bufferedReader = bufferedReader;
    }

    @Override
    public String read() throws IOException {
        return this.bufferedReader.readLine();
    }
}
