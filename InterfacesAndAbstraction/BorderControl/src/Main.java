import Abstracts.Birthable;
import Abstracts.Inhabitant;
import Models.Citizen;
import Models.Pet;
import Models.Robot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(streamReader);

        List<Birthable> born = new ArrayList<>();

        while(true){
            String inputLine = reader.readLine();

            boolean isBreak = inputLine.equals("End");
            if (isBreak){
                break;
            }

            String[] splitInput = inputLine.split("\\s+");
            String command = splitInput[0];
            String[] parameters =
                    Arrays.stream(splitInput)
                            .skip(1)
                            .limit(splitInput.length - 1)
                            .toArray(String[]::new);

            if (command.equals("Robot")){
                //inhabitants.add(createRobot(parameters));
            }
            else if(command.equals("Citizen")){
                born.add(createCitizen(parameters));
            }
            else if(command.equals("Pet")){
                born.add(createPet(parameters));
            }
        }

        String bornDate = reader.readLine();

        for (Birthable birthable : born) {
            if (birthable.getBirthDate().endsWith(bornDate)){
                System.out.println(birthable.getBirthDate());
            }
        }
    }

    public static Citizen createCitizen(String[] parameters){
        String name = parameters[0];
        int age = Integer.parseInt(parameters[1]);
        String id = parameters[2];
        String birthDate = parameters[3];

        Citizen citizen = new Citizen(name, age, id, birthDate);

        return citizen;
    }
    public static Robot createRobot(String[] parameters){
        String model = parameters[0];
        String id = parameters[1];

        Robot robot = new Robot(model, id);

        return robot;
    }
    public static Pet createPet(String[] parameters){
        String name = parameters[0];
        String birthDate = parameters[1];

        Pet pet = new Pet(name, birthDate);

        return pet;
    }
}
