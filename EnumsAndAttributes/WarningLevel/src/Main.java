import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(streamReader);

        String minimumLevel = reader.readLine();
        Logger logger = new Logger(minimumLevel, new ArrayList<>());

        while(true){
            String inputLine = reader.readLine();

            if (inputLine == null || inputLine.trim().length() == 0){
                throw new IllegalArgumentException("Input can not be null or empty.");
            }

            boolean isBreak = inputLine.equals("END");
            if (isBreak){
                break;
            }

            String[] arguments = inputLine.split("[:]");
            String level = arguments[0].trim();
            String text = arguments[1].trim();

            Message message = new Message(level, text);

            logger.addMessage(message);
        }

        Iterable<Message> iterator = logger.getMessages();
        for (Message message : iterator) {
            System.out.println(message);
        }

    }
}
