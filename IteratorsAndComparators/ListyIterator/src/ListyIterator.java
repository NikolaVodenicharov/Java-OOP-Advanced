import java.util.List;

public class ListyIterator<T> {
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
}
