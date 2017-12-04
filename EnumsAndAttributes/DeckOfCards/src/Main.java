import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(streamReader);

        Collection<Card> deck = createCardDeck();
        String formatted = collectionToString(deck, System.lineSeparator());
        System.out.println(formatted);
    }

    private static Card readCard(BufferedReader reader) throws IOException {
        String rank = reader.readLine();
        String suit = reader.readLine();

        Card card = new Card(rank, suit);

        return card;
    }
    private static Collection<Card> createCardDeck(){
        List<Card> deck = new ArrayList<>(52);

        for (CardSuit cardSuit : CardSuit.values()) {
            for (CardRank cardRank : CardRank.values()) {
                Card card = new Card(cardRank.name(), cardSuit.name());
                deck.add(card);
            }
        }

        return deck;
    }
    private static <T> String collectionToString (Collection<T> elements, Object connector){
        StringBuilder formatted = new StringBuilder();
        for (T element : elements) {
            formatted
                    .append(element)
                    .append(connector);
        }

        return formatted.toString().trim();
    }

}
