import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(streamReader);

        String inputValues = reader.readLine();
        String[] values = inputValues.split("\\s+");

        int len = values.length;
        Light[] lights = new Light[len];

        for (int i = 0; i < len; i++) {
            String lightName = values[i];
            Light inputLight = Light.valueOf(lightName);
            lights[i] = inputLight;
        }

        String inputCycles = reader.readLine();
        int cycles = Integer.parseInt(inputCycles);

        for (int i = 0; i < cycles; i++) {
            for (int j = 0; j < lights.length; j++) {
                lights[j] = lights[j].next();

                System.out.print(lights[j] + " ");
            }
            System.out.println();
        }
    }
}
