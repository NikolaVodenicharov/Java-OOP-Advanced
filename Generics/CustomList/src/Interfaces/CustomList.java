package Interfaces;

public interface CustomList<T> {
    void add(T element);
    void remove(int index);
    boolean contains(T element);
    void swap(int index1, int index2);
    int countGreaterThat(T element);
    T getMax();
    T getMin();

}
