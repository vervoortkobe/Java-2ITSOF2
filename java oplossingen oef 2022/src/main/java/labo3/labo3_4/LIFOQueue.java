package labo3.labo3_4;

public interface LIFOQueue<T> {
    Boolean isEmpty();
    void push(T add);
    T pop();
    T peek();
}
