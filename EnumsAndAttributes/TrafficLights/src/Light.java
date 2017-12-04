public enum Light {
    RED,
    GREEN,
    YELLOW;

    private static Light[] values = values();

    public Light next(){
        int index = (this.ordinal() + 1) % values().length;
        Light next = values[index];

        return next;
    }
}
