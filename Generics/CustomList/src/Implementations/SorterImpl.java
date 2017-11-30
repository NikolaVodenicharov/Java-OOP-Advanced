package Implementations;

import Interfaces.CustomList;
import Interfaces.Sorter;

public class SorterImpl<T extends Comparable<T>> implements Sorter<T> {

    @Override
    public void sort(CustomList<T> elements) {
        for (int i = 0; i < elements.size(); i++) {
            T currentElement = elements.get(i);

            for (int j = i + 1; j < elements.size(); j++) {
                T nextElement = elements.get(j);

                if (currentElement.compareTo(nextElement) > 0){
                    elements.swap(i, j);
                }
            }
        }
    }
}
