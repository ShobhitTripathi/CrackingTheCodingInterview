package StackAndQueue;

import java.util.LinkedList;

import java.util.EmptyStackException;

public class StackLinkedList <T> implements Stack<T> {
    private LinkedList<T> stack;

    public StackLinkedList() {
        stack = new LinkedList();
    }

    @Override
    public boolean isEmpty() {
        if (stack.size() == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void push(T element) {
        stack.addFirst(element);
    }

    @Override
    public T pop() {
        return stack.removeFirst();
    }

    @Override
    public T peek() {
        return stack.peek();
    }

    @Override
    public T getMinimum() {
        System.out.println("StackLinkedList: Not supported yet.");
        return null;
    }
}
