public class Message {
    private Importance level;
    private String text;

    public Message(String level, String text) {
        this.level = Enum.valueOf(Importance.class, level.toUpperCase());
        this.text = text;
    }

    public Importance getLevel() {
        return this.level;
    }

    @Override
    public String toString(){
        String formatted =
                String.format(
                        "%s: %s",
                        this.level,
                        this.text);

        return formatted;
    }
}
