package StackAndQueue;

import java.util.NoSuchElementException;
import java.util.LinkedList;

public class QueueUsingLinkedList<E> implements Queue<E> {
    LinkedList<E> list;

    public QueueUsingLinkedList() {
        list = new LinkedList<>();
    }

    @Override
    public void add(E element) {
        list.addLast(element);
    }

    @Override
    public E element() throws NoSuchElementException {
        return list.peek();
    }

    @Override
    public E remove() throws NoSuchElementException {
        return list.removeFirst();
    }

    @Override
    public boolean offer(E element) {
        return list.offer(element);
    }

    @Override
    public E peek() {
        return list.peek();
    }

    @Override
    public E poll() {
        return list.removeFirst();
    }
}
