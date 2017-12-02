import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer>{
    private List<Integer> numbers;

    public Lake(List<Integer> numbers){
        this.numbers = numbers;
    }


    @Override
    public Iterator<Integer> iterator() {
        return new LakeIterator();
    }

    private class LakeIterator implements Iterator<Integer>{
        private int index = 0;
        private boolean isEvenIndex = true;

        @Override
        public boolean hasNext() {
            boolean hasNextElement = this.index < numbers.size();

            if (this.isEvenIndex && !hasNextElement){
                this.isEvenIndex = false;
                this.index = 1;
                return true;
            }

            return hasNextElement;
        }

        @Override
        public Integer next() {
            int nextElement = numbers.get(this.index);
            this.index += 2;
            return nextElement;
        }
    }
}
