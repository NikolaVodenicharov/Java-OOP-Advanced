import java.util.Iterator;
import java.util.List;

public class ListyIterator<T> implements Iterable<T>{
    private List<T> elements;
    private int currentIdex;

    public ListyIterator(List<T> elements){
        this.elements = elements;
        this.currentIdex = 0;
    }

    public boolean Move(){
        boolean isMoved = false;

        if(this.hasNext()){
            this.currentIdex++;
            isMoved = true;
        }

        return isMoved;
    }

    public boolean hasNext(){
        boolean hasNext = (this.currentIdex + 1) < this.elements.size();

        return hasNext;
    }

    public void print(){
        if (this.elements.size() == 0){
            throw new IllegalArgumentException("Invalid Operation!");
        }
        System.out.println(this.elements.get(currentIdex));
    }

    public void printAll(){
        StringBuilder formatted = new StringBuilder();

        for (T element : elements) {
            formatted
                    .append(element)
                    .append(" ");
        }

        System.out.println(formatted.toString().trim());
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorOfListyIterator();
    }

    private class IteratorOfListyIterator implements Iterator<T>{
        int index = 0;

        @Override
        public boolean hasNext() {
            return this.index < elements.size();
        }

        @Override
        public T next() {
            return elements.get(this.index++);
        }
    }
}
