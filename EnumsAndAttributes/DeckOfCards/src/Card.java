public class Card implements Comparable<Card>{
    private CardRank rank;
    private CardSuit suit;
    private String name;

    public Card(String rank, String suit){
        this.rank = Enum.valueOf(CardRank.class, rank.toUpperCase());
        this.suit = Enum.valueOf(CardSuit.class, suit.toUpperCase());
        this.setName();
    }

    public CardRank getRank(){
        return this.rank;
    }

    public CardSuit getSuit(){
        return this.suit;
    }

    public String getName(){
        return this.name;
    }
    private void setName(){
        this.name =
                String.format(
                "%s of %s",
                this.rank.name(),
                this.suit.name());
    }

    private int calculateCardPower(){
        int power = this.rank.getPoints() + this.suit.getPoints();
        return power;
    }

    @Override
    public int compareTo(Card other) {
        return this.calculateCardPower() - other.calculateCardPower();
    }
}
