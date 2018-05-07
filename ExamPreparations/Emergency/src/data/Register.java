package data;

public interface Register<T>{
    void enqueue(T element);
    T dequeue();
    T peek();
    int Size();
    Boolean isEmpty();
}
