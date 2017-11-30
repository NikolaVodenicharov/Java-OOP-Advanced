package Interfaces;

public interface Sorter<T extends Comparable<T>> {
    void sort(CustomList<T> elements);
}
