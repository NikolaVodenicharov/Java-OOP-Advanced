public class Card implements Comparable<Card>{
    private CardRank rank;
    private CardSuit suit;

    public Card(String rank, String suit){
        this.rank = Enum.valueOf(CardRank.class, rank.toUpperCase());
        this.suit = Enum.valueOf(CardSuit.class, suit.toUpperCase());
    }

    private int calculateCardPower(){
        int power = this.rank.getPoints() + this.suit.getPoints();
        return power;
    }

    @Override
    public String toString(){
        String formatted =
                String.format(
                        "Card name: %s of %s; Card power: %d",
                        this.rank.name(),
                        this.suit.name(),
                        this.calculateCardPower());

        return formatted;
    }

    @Override
    public int compareTo(Card other) {
        return this.calculateCardPower() - other.calculateCardPower();
    }
}
