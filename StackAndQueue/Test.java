package StackAndQueue;

import java.util.LinkedList;
import StackAndQueue.AnimalShelter.*;

public class Test {

    static void stackUsingArrayTest () {
        System.out.println("Stack using array: Test code.");
        String word = "Hello World!";
        System.out.println(word);
        Stack <Character> stack = new StackArray<>(word.length());

        for(int i = 0; i < word.length(); i++) {
            stack.push(word.toCharArray()[i]);
        }

        String reversedWord = "";
        while(!stack.isEmpty()) {
            char ch = (char) stack.pop();
            reversedWord += ch;
        }
        System.out.println(reversedWord);
    }

    static void StackUsingLinkedListTest () {
        System.out.println("Stack using java.util.LinkedList: Test code.");
        String word = "Hello World!";
        System.out.println(word);
        Stack <Character> stack = new StackLinkedList<>();

        for(int i = 0; i < word.length(); i++) {
            stack.push(word.toCharArray()[i]);
        }

        String reversedWord = "";
        while(!stack.isEmpty()) {
            char ch = (char) stack.pop();
            reversedWord += ch;
        }
        System.out.println(reversedWord);
    }

    static void stackUsingArrayListTest () {
        System.out.println("Stack using java.util.ArrayList: Test code.");
        String word = "Hello World!";
        System.out.println(word);
        Stack <Character> stack = new StackArrayList<>();

        for(int i = 0; i < word.length(); i++) {
            stack.push(word.toCharArray()[i]);
        }

        String reversedWord = "";
        while(!stack.isEmpty()) {
            char ch = (char) stack.pop();
            reversedWord += ch;
        }
        System.out.println(reversedWord);
    }

    public static void minStackTest () {
        System.out.println("MinStack: Test code.");
        Stack<Integer> minStack = new MinStack<>();
        minStack.push(1);
        minStack.push(2);
        minStack.push(3);
        System.out.println("min element:"+ minStack.getMinimum());
    }

    public static void queueUsingArrayTest() {
        Queue<Character> queue = new QueueUsingArray<Character>();
        queue.add('1');
        System.out.println("using Array: poll(): " + queue.poll());

        queue.add('2');
        queue.add('3');
        queue.add('4');
        System.out.println("using Array: poll(): " + queue.poll());

        queue.add('5');
        queue.add('6');
        System.out.println("using Array: peek(): " + queue.peek());
        System.out.println("using Array: Remove(): " + queue.remove());
        System.out.println("using Array: element(): " + queue.element());
        queue.add('7');
        queue.add('8');
    }

    public static void queueUsingLinkedListTest() {
        Queue<Character> queue = new QueueUsingLinkedList<>();
        queue.add('1');
        System.out.println("UsingLinkedList: poll(): " + queue.poll());

        queue.add('2');
        queue.add('3');
        queue.add('4');
        System.out.println("UsingLinkedList: poll(): " + queue.poll());

        queue.add('5');
        queue.add('6');
        System.out.println("StackAndQueue: peek(): " + queue.peek());
        System.out.println("UsingLinkedList: Remove(): " + queue.remove());
        System.out.println("UsingLinkedList: element(): " + queue.element());
        queue.add('7');
        queue.add('8');
    }


    public static void queueUsingStackTest() {
        Queue<Character> queue = new QueueUsingStacks<>();
        queue.add('1');
        System.out.println("UsingStack: poll(): " + queue.poll());

        queue.add('2');
        queue.add('3');
        queue.add('4');
        System.out.println("UsingStack: poll(): " + queue.poll());

        queue.add('5');
        queue.add('6');
        System.out.println("UsingStack: peek(): " + queue.peek());
        System.out.println("UsingStack: Remove(): " + queue.remove());
        System.out.println("UsingStack: element(): " + queue.element());
        queue.add('7');
        queue.add('8');
    }

    public static void animalShelterTest() {
        Animals a1 = new Cat();
        a1.setName("happy");

        Animals a3 = new Cat();
        a3.setName("Lily");

        Animals a2 = new Dog();
        a2.setName("Tuffy");

        Animals a4 = new Dog();
        a4.setName("Tyson");


        FifoAnimalShelter queue = new FifoAnimalShelter();
        queue.add(a4);
        queue.add(a2);
        queue.add(a3);
        queue.add(a1);

        FactoryAnimal fa = new FactoryAnimal();

        Animals n1 = queue.get(fa.getInstance("Cat"));
        System.out.println(n1.getType());
        n1.printName();

        Animals n2 = queue.get();
        System.out.println(n2.getType());
        n2.printName();
    }


    public static void main (String[] args) {
//        stackUsingArrayTest();
//        StackUsingLinkedListTest();
//        stackUsingArrayListTest();
//        minStackTest();

//        queueUsingArrayTest();
//        System.out.println();
//        queueUsingLinkedListTest();
//        System.out.println();
//        queueUsingStackTest();
        animalShelterTest();


    }
}
