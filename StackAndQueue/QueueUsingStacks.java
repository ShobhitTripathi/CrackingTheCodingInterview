package StackAndQueue;

import java.util.NoSuchElementException;
import java.util.Stack;

/*
enQueue(q, x):
While stack1 is not empty, push everything from stack1 to stack2.
Push x to stack1 (assuming size of stacks is unlimited).
Push everything back to stack1.
Here time complexity will be O(n)

deQueue(q):
If stack1 is empty then error
Pop an item from stack1 and return it
Here time complexity will be O(1)


We can do swap the time complexity of enqueue and dequeue accordingly.
 */
public class QueueUsingStacks<E> implements Queue<E>{
    Stack<E> stack1 = new Stack<>();
    Stack<E> stack2 = new Stack<>();


    @Override
    public void add(E element) {
        // Move all elements from stack1 to stack2
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
            //stack1.pop();
        }

        // Push item into stack1
        stack1.push(element);

        // Push everything back to stack1
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
            //stack2.pop();
        }
    }

    @Override
    public E element() throws NoSuchElementException {
        return stack1.peek();
    }

    @Override
    public E remove() throws NoSuchElementException {
        return stack1.pop();
    }

    @Override
    public boolean offer(E element) {
        System.out.println("Current implementation does not support");
        return false;
    }

    @Override
    public E peek() {
        return stack1.peek();
    }

    @Override
    public E poll() {
        return stack1.pop();
    }
}
