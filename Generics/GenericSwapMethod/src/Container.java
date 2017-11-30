import java.util.List;

public class Container<T> {
    private List<T> elements;

    public Container(List<T> elements) {
        this.elements = elements;
    }

    public void addElement(T element){
        this.elements.add(element);
    }

    public void reposition(int index1, int index2){
        if (index1 >= elements.size() || index2 >= elements.size()){
            throw new IllegalArgumentException("Index out of range.");
        }

        T element = this.elements.get(index1);
        this.elements.set(index1, this.elements.get(index2));
        this.elements.set(index2, element);
    }

    @Override
    public String toString(){
        StringBuilder formatted = new StringBuilder();

        for (T element : elements) {
            formatted
                    .append(String.format(
                            "%s: %s",
                            element.getClass().getName(),
                            element))
                    .append(System.lineSeparator());
        }

        return formatted.toString().trim();
    }
}
