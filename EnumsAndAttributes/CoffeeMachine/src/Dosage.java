public enum  Dosage {
    SMALL (50, 50),
    NORMAL (100, 75),
    DOUBLE (200, 100);

    private int volume;
    private int price;

    private Dosage(int volume, int price){
        this.volume = volume;
        this.price = price;
    }

    public int getPrice(){
        return this.price;
    }
}
