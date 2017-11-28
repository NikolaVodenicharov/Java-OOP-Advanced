import Abstracts.Birthable;
import Abstracts.Buyer;
import Models.Citizen;
import Models.Pet;
import Models.Rebel;
import Models.Robot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(streamReader);

        Map<String, Buyer> buyers = readBuyers(reader);

        while(true) {
            String buyerName = reader.readLine();

            boolean isBreak = buyerName.equals("End");
            if (isBreak) {
                break;
            }

            if (buyers.containsKey(buyerName)){
                buyers.get(buyerName).buyFood();
            }
        }

        int foodQuantity =
                buyers
                .entrySet()
                .stream()
                .mapToInt(b -> b.getValue().getFood())
                .sum();

        System.out.println(foodQuantity);
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
    public static Rebel createRebel(String[] parameters){
        String name = parameters[0];
        int age = Integer.parseInt(parameters[1]);
        String group = parameters[2];

        Rebel rebel = new Rebel(name, age, group);

        return rebel;
    }
    public static Map<String, Buyer> readBuyers(BufferedReader reader) throws IOException {
        int inputBuyersNumber = Integer.parseInt(reader.readLine());
        Map<String, Buyer> buyers = new HashMap<>(inputBuyersNumber);

        for (int i = 0; i < inputBuyersNumber; i++) {
            String[] parameters = reader.readLine().split("\\s+");

            if (parameters.length == 4){
                String name = parameters[0];
                Buyer buyer = createCitizen(parameters);
                buyers.put(name, buyer);
            }
            else if (parameters.length == 3){
                String name = parameters[0];
                Buyer buyer = createRebel(parameters);
                buyers.put(name, buyer);
            }
            else{
                // exception ?
            }
        }

        return buyers;
    }
}
