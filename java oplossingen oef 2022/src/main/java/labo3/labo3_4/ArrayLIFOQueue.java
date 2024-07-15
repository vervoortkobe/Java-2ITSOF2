package labo3.labo3_4;

import java.util.ArrayDeque;

public class ArrayLIFOQueue<T> implements LIFOQueue<T>{

    ArrayDeque<T> queueArrayDeque = new ArrayDeque<T>();

    @Override
    public Boolean isEmpty() {
        return queueArrayDeque.isEmpty();
    }

    @Override
    public void push(T add) {
        queueArrayDeque.push(add);
    }

    @Override
    public T pop() {
        return queueArrayDeque.pop();
    }

    @Override
    public T peek() {
        return queueArrayDeque.peek();
    }
}
