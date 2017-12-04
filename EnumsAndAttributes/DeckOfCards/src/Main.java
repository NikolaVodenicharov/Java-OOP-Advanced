import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(streamReader);

        String command = reader.readLine();

        if (command.equals("Rank")){
            Class cl = CardRank.class;
            CardsAnnotation annotation = (CardsAnnotation) cl.getAnnotation(CardsAnnotation.class);

            String formatted =
                    String.format(
                            "Type = %s, Description = %s",
                            annotation.type(),
                            annotation.description());
            System.out.println(formatted);
        }
        else{
            Class cl = CardSuit.class;
            CardsAnnotation annotation = (CardsAnnotation) cl.getAnnotation(CardsAnnotation.class);

            String formatted =
                    String.format(
                            "Type = %s, Description = %s",
                            annotation.type(),
                            annotation.description());
            System.out.println(formatted);
        }
    }

    private static Card readCard(BufferedReader reader) throws IOException {
        String rank = reader.readLine();
        String suit = reader.readLine();

        Card card = new Card(rank, suit);

        return card;
    }
}
