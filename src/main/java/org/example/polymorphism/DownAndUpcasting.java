package org.example.polymorphism;

//Since you lose the specific type information via an upcast (moving up the inheritance
//        hierarchy), it makes sense that to retrieve the type information—that is, to move back down
//        the inheritance hierarchy—you use a downcast.
//WHY?? if the sub class has extra methods -> you can't access them when you do down casting
// in order to access them, you must downcast
public class DownAndUpcasting {
    public static void main(String[] args) {
       Animal animal = new Dog();
       animal.makeSound();
//       animal.fetch(); -> can't access the fetch method => downcast
//         animal = (Dog) animal;
//        ((Dog) animal).fetch();

        // Downcasting (explicit casting) allows access to derived class-specific methods
         Dog dog = (Dog) animal;
         dog.fetch();

    }
}

class Animal {
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }

    public void fetch() {
        System.out.println("Dog fetches a ball");
    }
}