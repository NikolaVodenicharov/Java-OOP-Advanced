import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(streamReader);

        CoffeeMachine machine = new CoffeeMachine(0, new ArrayList<>());

        while(true){
            String[] commands = reader.readLine().split("\\s+");

            boolean isBreak = commands[0].equals("END");
            if (isBreak){
                break;
            }

            if(commands.length == 1){
                machine.insertCoin(commands[0]);
            }
            else{
                machine.buyCoffee(commands[0], commands[1]);
            }
        }
    }
}
