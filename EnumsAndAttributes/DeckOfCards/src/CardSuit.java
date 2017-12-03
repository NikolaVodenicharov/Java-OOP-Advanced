public enum CardSuit {
    CLUBS,
    DIAMONDS,
    HEARTS,
    SPADES;

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
