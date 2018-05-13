package core;

import io.InputReader;
import io.OutputWriter;

import java.io.IOException;

public class Engine implements Runnable {
    private InputReader reader;
    private OutputWriter writer;

    public Engine(InputReader reader, OutputWriter writer){
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public void run() throws IOException {
        while(true){
            String line = reader.readLine();

            if (line == null && line.trim().isEmpty()){
                break;
            }

            String[] split = line.split("\\s+");
            String command = split[0];
        }
    }
}
