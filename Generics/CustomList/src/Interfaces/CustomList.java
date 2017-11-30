package Interfaces;

import java.util.Collection;

public interface CustomList<T extends Comparable<T>> {
    void add(T element);
    void remove(int index);
    boolean contains(T element);
    void swap(int index1, int index2);
    int countGreaterThat(T element);
    T getMax();
    T getMin();
    T get(int index);
    int size();
}
