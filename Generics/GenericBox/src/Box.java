public class Box <T> {
    T data;

    public Box(T data) {
        this.data = data;
    }

    @Override
    public String toString(){
        String formatted =
                String.format(
                        "%s: %s",
                        data.getClass().getName(),
                        data);

        return formatted;
    }
}
