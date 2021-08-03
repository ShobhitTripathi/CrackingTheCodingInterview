package StackAndQueue;

import java.lang.reflect.Array;
import java.util.EmptyStackException;

public class StackArray<T> implements Stack<T> {
    private Object[] array;
    private int top;
    private int max_size;

    public StackArray(int max_size) {
        this.max_size = max_size;
        this.array = new Object[max_size];
        this.top = -1;
    }

    private Object[] resizeArray () {
        max_size *= 2;
        int new_size = max_size;
        Object[] newArray = new Object[new_size];
        for(int i = 0; i < MAX_SIZE; i++) {
            newArray[i] = this.array[i];
        }
        return newArray;
    }

    @Override
    public boolean isEmpty () {
        return top == -1;
    }

    @Override
    public boolean isFull () {
        return top == max_size - 1;
    }

    @Override
    public void push (T element) {
        if (!isFull()) {
            array[++top] = element;
        } else {
            this.array = resizeArray();
            array[++top] = element;
        }
    }

    @Override
    public T pop () {
        if (!this.isEmpty()) {
            return (T) array[top--];
        }else {
            throw new EmptyStackException();
        }
    }

    @Override
    public T peek() {
        return (T)array[top];
    }

    @Override
    public T getMinimum() {
        System.out.println("StackArray:Not supported yet.");
        return null;
    }
}
