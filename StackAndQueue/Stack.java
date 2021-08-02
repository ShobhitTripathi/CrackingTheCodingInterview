package StackAndQueue;

public interface Stack<T> {

    int MAX_SIZE = 1024;

    boolean isEmpty();

    boolean isFull();

    void push(T element);

    T pop();

    T peek();

    T getMinimum();
}
