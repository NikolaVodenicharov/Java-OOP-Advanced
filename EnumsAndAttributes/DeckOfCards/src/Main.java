import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(streamReader);

        String rank = reader.readLine();
        String suit = reader.readLine();

        Card card = new Card(rank, suit);

        System.out.println(card);
    }
}
