import Abstracts.Inhabitant;
import Models.Citizen;
import Models.Robot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(streamReader);

        List<Inhabitant> inhabitants = new ArrayList<>();

        while(true){
            String inputLine = reader.readLine();

            boolean isBreak = inputLine.equals("End");
            if (isBreak){
                break;
            }

            String[] parameters = inputLine.split("\\s+");
            if (parameters.length == 2){
                inhabitants.add(createRobot(parameters));
            }
            else{
                inhabitants.add(createCitizen(parameters));
            }
        }

        String fakeIdLastDigits = reader.readLine();

        for (Inhabitant inhabitant : inhabitants) {
            if (inhabitant.getId().endsWith(fakeIdLastDigits)){
                System.out.println(inhabitant.getId());
            }
        }
    }

    public static Citizen createCitizen(String[] parameters){
        String name = parameters[0];
        int age = Integer.parseInt(parameters[1]);
        String id = parameters[2];

        return new Citizen(name, age, id);
    }
    public static Robot createRobot(String[] parameters){
        String model = parameters[0];
        String id = parameters[1];

        return new Robot(model, id);
    }
}
