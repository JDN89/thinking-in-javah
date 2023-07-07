package org.example.typeinformation;

import java.util.ArrayList;
import java.util.Collection;

public class InstanceThisBiatch {
    public static void main(String[] args) {
        Animal myDog = new Dog();
        Animal myCat = new Cat();
        Collection<Animal> animalz = new ArrayList<>();
        animalz.add(myCat);
        animalz.add(myDog);
        // you can call the overriden methods because at runtime the correct methods get called: dynamic binding
        // but you can't call methods that are only defined in the childclass
        // because we start from the Class object and the upcasting stops at Animal
        // so we don't know the exact sublcass type Cat or Dog
        // for this we need to use instance of
        for (Animal animal : animalz) {
            // I can only call animal.makeSound();
            // because we don;t know whether it is a dog or a cat
            animal.makeSound();
            System.out.println(animal.getClass());
        }
        for (Animal animal : animalz) {
            if (animal instanceof Dog) {
                //Via instance of I can call the dog specific methods!!
                ((Dog) animal).dogSpecificMethod();
                System.out.println("This animal is an instance of Dog");
            } else if (animal instanceof Cat) {
                System.out.println("This animal is an instance of Cat");
            }
        }

        for (Animal animal : animalz) {
            if (Dog.class.isInstance(animal)) {
                System.out.println("This animal is an instance of Dog");
            } else if (Cat.class.isInstance(animal)) {
                System.out.println("This animal is an instance of Cat");
            }
        }
    }
}

class Animal {
    public void makeSound() {
        System.out.println("The animal makes sound");
    }
}

class Dog extends Animal {
    public void dogSpecificMethod() {
        System.out.println("only dogs can do this");
    }

    @Override
    public void makeSound() {
        System.out.println("The dog barks");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("the cat meows");
        ;
    }
}