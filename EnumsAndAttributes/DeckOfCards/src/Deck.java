import java.util.HashMap;
import java.util.Map;

public class Deck {
    Map<String, Card> deck;

    public Deck(){
        this.deck = createCardDeck();
    }

    public Card takeCard(String cardName){
        if (!this.deck.containsKey(cardName)){
            throw new IllegalArgumentException("No such card exists.");
        }
        if (this.deck.get(cardName) == null){
            throw new IllegalStateException("Card is not in the deck.");
        }

        Card card = this.deck.get(cardName);
        this.deck.put(cardName, null);

        return card;
    }

    private static Map<String, Card> createCardDeck(){
        HashMap<String, Card> deck = new HashMap<>(52);

        for (CardSuit cardSuit : CardSuit.values()) {
            for (CardRank cardRank : CardRank.values()) {
                Card card = new Card(cardRank.name(), cardSuit.name());
                deck.put(card.getName(), card);
            }
        }

        return deck;
    }
}
