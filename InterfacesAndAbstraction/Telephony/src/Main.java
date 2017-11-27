import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(streamReader);

        String[] phoneNumbers = reader.readLine().split("\\s+");
        String[] sites = reader.readLine().split("\\s+");

        Smartphone phone = new Smartphone();

        for (String phoneNumber : phoneNumbers) {
            phone.call(phoneNumber);
        }

        for (String site : sites) {
            phone.browse(site);
        }
    }
}
