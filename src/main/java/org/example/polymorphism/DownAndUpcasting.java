package org.example.polymorphism;

//Since you lose the specific type information via an upcast (moving up the inheritance
//        hierarchy), it makes sense that to retrieve the type information—that is, to move back down
//        the inheritance hierarchy—you use a downcast.
//WHY?? if the sub class has extra methods -> you can't access them when you do down casting
// in order to access them, you must downcast
public class DownAndUpcasting {
    public static void main(String[] args) {
        //upcasting
        Animal[] animalz = new Animal[2];
        animalz[0] = new Dog();
        animalz[1] = new Cat();
        for(Animal an: animalz) {
            an.sound();
            if (an instanceof Dog) {
                ((Dog) an).fetch();
            }
            //downCasting
            if (an instanceof Cat) {
                Cat cat = (Cat) an;
                ((Cat) an).scratch();
            }
        }

        Animal[] animals = new Animal[2];
        animals[0] = new Dog();
        animals[1] = new Cat();

        for (Animal animal : animals) {
            animal.sound(); // Polymorphic behavior based on actual object type

            // animal.fetch(); // Compilation error - Animal reference doesn't have fetch() method

            if (animal instanceof Dog) {
                Dog dog = (Dog) animal;
                dog.fetch(); // Accessing specific behavior of Dog
            } else if (animal instanceof Cat) {
                Cat cat = (Cat) animal;
                cat.scratch(); // Accessing specific behavior of Cat
            }
        }
    }
}
//    Using upcasting, we assign a Dog object and a Cat object to the array elements. During the iteration over the array, the sound() method is invoked on each Animal object. Here, polymorphism comes into play, as the actual implementation of sound() in each subclass (Dog and Cat) is dynamically called based on the object type.
//
//        However, since the array is of type Animal, we cannot directly access the fetch() method on the Animal reference. To access the specific behavior of Dog or Cat, we utilize the instanceof operator to check the object type. If the object is of type Dog, we perform a downcast to Dog and invoke the fetch() method. Similarly, if the object is of type Cat, we downcast to Cat and invoke the scratch() method.
//
//        This example demonstrates how upcasting in combination with instanceof and downcasting allows you to work with different subclasses within an array of the superclass type, enabling polymorphic behavior and selective access to specific behaviors of the subclasses.

class Animal {
    public void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("Dog barks");
    }

    public void fetch() {
        System.out.println("Dog fetches a ball");
    }
}

class Cat extends Animal {
    @Override
    public void sound() {
        System.out.println("Cat meows");
    }

    public void scratch() {
        System.out.println("Cat scratches");
    }
}