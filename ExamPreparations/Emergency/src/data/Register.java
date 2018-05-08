package data;

public interface Register<T>{
    void enqueue(T element);
    T dequeue();
    T peek();
    int size();
    Boolean isEmpty();
}
