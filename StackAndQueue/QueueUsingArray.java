package StackAndQueue;

import java.util.NoSuchElementException;

public class QueueUsingArray<E> implements Queue<E> {
    private Object[] data;
    private int front, size, last;

    public final static int DEFAULT_INITIAL_ARRAY_SIZE = 16;

    /**
     * MAX_ARRAY_SIZE is set to Integer.MAX_VALUE - 8 to prevent OutOfMemoryErrors.
     */
    public static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    public QueueUsingArray() {
        this.data = new Object[DEFAULT_INITIAL_ARRAY_SIZE];
    }

    public QueueUsingArray(int capacity) throws IllegalArgumentException {
        if (capacity < 1) {
            throw new IllegalArgumentException("Queue capacity must be 1 or greater");
        }

        if (capacity > MAX_ARRAY_SIZE) {
            throw new IllegalArgumentException("Stack capacity is greater then maximum array size");
        }

        // Data variable is private so it will never be returned to the client
        // and the only method that can push elements onto the array would have to be the same type so it is OK
        // to suppress the warning message.
        @SuppressWarnings("unchecked")
        E[] tempData = (E[]) new Object[capacity];
        data = tempData;
    }

    @Override
    public void add(E element) throws IllegalArgumentException {
        if (size == data.length) {
            throw new IllegalArgumentException("Ran out of memory to queue");
        }
        data[last] = element;
        last = (last + 1) % data.length;
        size++;
    }

    @Override
    public E element() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException("Queue does not contain any items.");
        }
        return (E)data[front];
    }

    @Override
    public E remove() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException("Queue does not contain any items.");
        }
        size--;
        E output = (E)data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        return output;
    }

    @Override
    public boolean offer(E element) {
        if (size == data.length) {
            return false;
        }

        size++;
        data[last] = element;
        last = (last + 1) % data.length;
        return true;
    }

    @Override
    public E peek() {
        return size == 0 ? null : (E)data[front];
    }

    @Override
    public E poll() {
        if (size == 0) {
            return null;
        }

        E output= (E)data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        return output;
    }
}
