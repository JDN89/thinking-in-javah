package org.example.interfaces;

public class MultipleInheritance {
    public static void main(String[] args) {


    }

}

interface CanFight {
    void fight();
}

interface CanSwim {
    void swim();
}

interface CanFly {
    void fly();
}

class ActionCharacter {
    public void fight() {
        System.out.println("this fight method?");
    }
}

class Hero extends ActionCharacter
        implements CanFight, CanSwim, CanFly {
    public void swim() {
    }

    public void fly() {
    }

}
//    In the main() method of the Adventure class, the Hero object h is treated polymorphically by calling the different methods t(), u(), v(), and w() with the h object as an argument. This demonstrates how the Hero object can be treated as different types/interfaces, and the appropriate method is invoked based on the interface or superclass type.

//        This code showcases the concept of polymorphism in Java, where an object can be treated as different types/interfaces, allowing for flexibility and reusability of code. It demonstrates a scenario where a class inherits from a superclass and implements multiple interfaces, utilizing the capabilities of inheritance and interface implementation.
class Adventure {
    public static void t(CanFight x) {
        x.fight();
    }

    public static void u(CanSwim x) {
        x.swim();
    }

    public static void v(CanFly x) {
        x.fly();
    }

    public static void w(ActionCharacter x) {
        x.fight();
    }

    public static void main(String[] args) {
//        Hero implements and extends the above interfaces and class
//        at compile time the right methods get called based on the signature of the STATIC methods
//                if we had overwritten any of the methods in the super class,
//        runtime polymorphism and dynamic method dispatch would have occurred, determining the actual method to be executed based on the runtime type of the objec
        Hero h = new Hero();
        t(h); // Treat it as a CanFight
        u(h); // Treat it as a CanSwim
        v(h); // Treat it as a CanFly
        w(h); // Treat it as an ActionCharacter
        h.fight();
    }
} ///:~