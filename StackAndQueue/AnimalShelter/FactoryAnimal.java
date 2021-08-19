package StackAndQueue.AnimalShelter;

public class FactoryAnimal {

    public static Animals getInstance(String str) {
        if (str.equals("Cat"))
            return new Cat();
        else
            return new Dog();
    }
}
