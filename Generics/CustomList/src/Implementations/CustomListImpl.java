package Implementations;

import Interfaces.CustomList;

import java.util.*;
import java.util.function.Consumer;

public class CustomListImpl<T extends Comparable<T>> implements CustomList<T> {
    private List<T> elements;

    public CustomListImpl(){
        this.elements = new ArrayList<>();
    }

    public void add(T element){
        this.elements.add(element);
    }

    public void remove(int index){
        this.elements.remove(index);
    }
    public boolean contains(T element){
        boolean isContained = this.elements.contains(element);

        return isContained;
    }
    public void swap(int index1, int index2){
        Collections.swap(this.elements, index1, index2);
    }
    public int countGreaterThat(T target){
        int counter = 0;

        for (T element : elements) {
            if (element.compareTo(target) > 0){
                counter++;
            }
        }

        return counter;
    }
    public T getMax(){
        if (this.elements.size() == 0){
            throw new IllegalArgumentException("The list is empty.");
        }

        T max =
                this.elements
                .stream()
                .max(Comparable::compareTo)
                .get();

        return max;
    }
    public T getMin(){
        if (this.elements.size() == 0){
            throw new IllegalArgumentException("The list is empty.");
        }

        T min =
                this.elements
                        .stream()
                        .min(Comparable::compareTo)
                        .get();

        return min;
    }

    @Override
    public T get(int index) {
        return this.elements.get(index);
    }

    @Override
    public int size() {
        return this.elements.size();
    }

    public String toString(){
        StringBuilder formatted = new StringBuilder();
        for (T element : this.elements) {
            formatted
                    .append(element)
                    .append(System.lineSeparator());
        }

        return formatted.toString().trim();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public T next() {
                return null;
            }
        };
    }

    private class CustomListInterator implements Iterator<T>{
        int index = 0;

        @Override
        public boolean hasNext() {
            return index < elements.size();
        }

        @Override
        public T next() {
            return elements.get(index++);
        }
    }
}
