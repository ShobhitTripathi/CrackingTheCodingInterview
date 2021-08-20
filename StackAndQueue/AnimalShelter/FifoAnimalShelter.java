package StackAndQueue.AnimalShelter;
import java.util.EmptyStackException;
import java.util.LinkedList;

public class FifoAnimalShelter implements AnimalShelter{
    LinkedList<Animals> cats;
    LinkedList<Animals> dogs;
    private int order;

    public FifoAnimalShelter() {
        this.order = 0;
        cats = new LinkedList<>();
        dogs = new LinkedList<>();
    }

    @Override
    /**
     * Check the type of Animal instance and insert in respective 'stack'.
     * @param animal
     * @return boolean
     */
    public boolean add(Animals animal) {
        /**
         * order is used as a sort of time stamp.
         * It can be used to compare the insertion order of a dog to a cat.
         **/
        animal.setOrder(order++);
        if (animal instanceof Cat) {
            return cats.add((Cat) animal);
        } else {
            return dogs.add((Dog) animal);
        }
    }

    @Override
    public Animals get(Animals animal) {
        if (animal instanceof Cat) {
            return dequeueCat();
        } else {
            return dequeueDog();
        }
    }



    /**
     * getAnyAnimal cases:
     * #1: if both stacks are empty, throw exception as no Animal will found.
     * #2: if dogs stack is empty, return top from the cats stack.
     * #3: if cats stack is empty, return top from the dogs stack.
     * #4: if cats & dogs contains element, return older of top of both stack.
     * @return
     */
    public Animals get() {
        System.out.println("dequeueAny");
        if (dogs.isEmpty() && cats.isEmpty()) {
            throw new EmptyStackException();
        } else if (dogs.isEmpty()) {
            return dequeueCat();
        } else if (cats.isEmpty()) {
            return dequeueDog();
        }

        /**
         * Look at top of dog and cat queues, and pop the queue with the oldest value.
         */
        Animals dog = dogs.peek();
        Animals cat = cats.peek();
        boolean isDog = dog.isOlderThan(cat);

        if (isDog) {
            return dequeueDog();
        } else {
            return dequeueCat();
        }

    }

    /**
     * Return the top of dogs Queue.
     * @return animal
     */
    public Animals dequeueDog() {
        System.out.println("dequeueDog");
        return dogs.poll();
    }

    /**
     * Return the top of cats Queue.
     * @return animal
     */
    public Animals dequeueCat() {
        System.out.println("dequeueCat");
        return cats.poll();
    }
}
