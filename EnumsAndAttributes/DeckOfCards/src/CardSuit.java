@CardsAnnotation(type = "Enumeration", category = "Suit", description = "Provides suit constants for a Card class.")
public enum CardSuit {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private int points;

    private CardSuit(int points){
        this.points = points;
    }

    public int getPoints(){
        return this.points;
    }

    @Override
    public String toString(){
        String formatted =
                String.format(
                        "Ordinal value: %d; Name value: %s",
                        this.ordinal(),
                        this.name());

        return formatted;
    }
}
