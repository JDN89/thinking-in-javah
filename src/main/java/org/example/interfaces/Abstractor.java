package org.example.interfaces;

import java.util.List;

public class Abstractor {

    public static void main(String[] args) {
         List<Animal> animals = List.of(new Dog(),new Cat()) ;
        animals.forEach(Animal::makeSound);
        animals.forEach(a -> {
            if (a instanceof Dog) {
                ((Dog) a).dogi();
            }
        });
    }
}

abstract class Animal {

    public int age;
    abstract void run();

    abstract void makeSound();

    public void fetch() {
        System.out.println("fetching the ball");
    }
}

//obligated to use all the methods from the abstract class
class Dog extends Animal {
    @Override
    void run() {
        System.out.println("running loudly");
    }
    public void dogi() {
        age=5;
        System.out.println("who let the dogs out" + age);
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