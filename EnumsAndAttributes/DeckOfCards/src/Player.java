import java.util.List;

public class Player {
    private String name;
    private List<Card> handCards;

    public Player(String name, List<Card> handCards) {
        this.name = name;
        this.handCards = handCards;
    }

    public String getName(){
        return this.name;
    }

    public void addCard(Card card){
        this.handCards.add(card);
    }

    public int handCardsCount(){
        return this.handCards.size();
    }

    public Card findStrongesCard(){
        Card strongest = this.handCards.get(0);
        for (int i = 1; i < this.handCards.size(); i++) {
            if (strongest.compareTo(this.handCards.get(i)) < 0){
                strongest = this.handCards.get(i);
            }
        }

        return strongest;
    }


}
