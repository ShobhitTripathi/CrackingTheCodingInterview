package StackAndQueue;

public class MinStack<T> implements Stack<T>{
    Stack<T> elementStack = new StackLinkedList<>();
    Stack<T> minStack = new StackLinkedList<>();

    @Override
    public boolean isEmpty() {
        return elementStack.isEmpty();
    }

    @Override
    public boolean isFull() {
        return elementStack.isFull();
    }

    @Override
    public void push(T element) {
        elementStack.push(element);
        if (minStack.isEmpty() || (Integer)element < (Integer)minStack.peek()) {
            minStack.push(element);
        }
    }

    @Override
    public T pop() {
        if(elementStack.isEmpty()) {
            return null;
        } else {
            if ((Integer)elementStack.peek() == (Integer)minStack.peek()) {
                minStack.pop();
            }
        }
        return elementStack.pop();
    }

    @Override
    public T peek() {
        return elementStack.peek();
    }

    public T getMinimum() {
        return minStack.peek();
    }
}
