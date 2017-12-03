import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(streamReader);

        Card card1 = readCard(reader);
        Card card2 = readCard(reader);

        if (card1.compareTo(card2) >= 0){
            System.out.println(card1);
        }
        else{
            System.out.println(card2);
        }
    }

    private static Card readCard(BufferedReader reader) throws IOException {
        String rank = reader.readLine();
        String suit = reader.readLine();

        Card card = new Card(rank, suit);

        return card;
    }
}
