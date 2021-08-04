package StackAndQueue;

import java.util.ArrayList;

public class StackArrayList<T> implements Stack<T>{
    ArrayList<T> arrayList;
    int top = -1;

    public StackArrayList() {
        this.arrayList = new ArrayList<>();
    }

    @Override
    public boolean isEmpty() {
        if (arrayList.size() == 0)
            return true;
        return false;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void push(T element) {
        top++;
        arrayList.add(top,element);
    }

    @Override
    public T pop() {
        T temp = arrayList.get(top);
        arrayList.remove(top);
        top--;
        return temp;
    }

    @Override
    public T peek() {
        // If stack is empty
        if (top == -1) {
            // Display message when there are no elements in
            // the stack
            System.out.println("Stack Underflow");
            return null;
        }
        // else elements are present so
        // return the topmost element
        else
            return arrayList.get(top);
    }

    @Override
    public T getMinimum() {
        System.out.println("StackArrayList:Not supported yet.");
        return null;
    }

    public String toString() {
        String ans = "";
        for (int i = 0; i < top; i++) {
            ans += String.valueOf(arrayList.get(i)) + "->";
        }
        ans += String.valueOf(arrayList.get(top));
        return ans;
    }
}
