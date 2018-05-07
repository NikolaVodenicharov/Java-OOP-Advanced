package data;

import data.Register;

public class RegisterImpl<T> implements Register<T> {

    private static final Integer INITIAL_SIZE = 16;
    private T[] elements;
    private Integer currentSize;
    private Integer nextIndex;

    public RegisterImpl() {
        this.elements = (T[]) new Object[INITIAL_SIZE];
        this.currentSize = 0;
        this.nextIndex = 0;
    }

    @Override
    public void enqueue(T element) {
        this.checkIfResizeNeeded();

        this.elements[this.nextIndex] = element;
        this.incrementNextIndex();

        this.incrementCurrentSize();
    }
    @Override
    public T dequeue() {
        T element = this.elements[0];

        System.arraycopy(this.elements, 1, this.elements, 0, this.currentSize - 1);

        this.decrementNextIndex();
        this.decrementCurrentSize();

        return element;
    }
    @Override
    public T peek() {
        T element = this.elements[0];
        return element;
    }

    @Override
    public int Size() {
        int size = currentSize + 1;
        return size;
    }

    @Override
    public Boolean isEmpty() {
        boolean isEmpty = this.currentSize == 0;
        return isEmpty;
    }

    private void incrementNextIndex() {
        this.nextIndex++;
    }
    private void decrementNextIndex() {
        this.nextIndex--;
    }
    private void incrementCurrentSize() {
        this.currentSize++;
    }
    private void decrementCurrentSize() {
        this.currentSize--;
    }
    private void checkIfResizeNeeded() {
        if(this.currentSize == this.elements.length) {
            this.resize();
        }
    }
    private void resize() {
        T[] newArray = (T[]) new Object[2 * this.currentSize];

        System.arraycopy(this.elements, 0, newArray, 0, this.currentSize);

        this.elements = newArray;
    }
}
