package org.example.interfaces;

public class Abstractor {

    public static void main(String[] args) {
        Animal[] animals = {
                new Dog(),
                new Cat()
        };
        Animals.animalsMakeSound(animals);
    }
}

abstract class Animal {
    abstract void run();

    abstract void makeSound();
}

//obligated to use all the methods from the abstract class
class Dog extends Animal {
    @Override
    void run() {
        System.out.println("running loudly");
    }

    @Override
    void makeSound() {
        System.out.println("woof");

    }
}

class Animals {
    static void animalsMakeSound(Animal[] a) {
        for (Animal animal : a) {
            animal.makeSound();
        }
    }
}

class Cat extends Animal {

    @Override
    void run() {
        System.out.println("stalking ");
    }

    @Override
    void makeSound() {
        System.out.println("miaauuuw");
    }
}