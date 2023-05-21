package org.example.reusingclasses;

//final keyword

import org.w3c.dom.ls.LSOutput;

class A {
    protected int k = 9;
    private int b = 3;

    public int getB() {
        return b;
    }

    public void setK(int k) {
        this.k = k;
    }

    void doSomething() {
        System.out.println("doing stuf");
    }

    public void setB(int b) {
        this.b = b;
    }
}
class B extends A {

    void printer() {
        System.out.println(k);
        System.out.println();
    }


}

class Value {
    private int i;

    public Value(int i) {
        this.i = i;
    }
}

class Finalizer {

    public Finalizer() {
    }

    public Finalizer(Value v1) {
        this.v1 = v1;
    }
    private String string = "jan";

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public void adder(final int i, int b) {
//        i = i+1; DOES NOT WORK
        b =b+i; // DOES WORK
        System.out.println(i +1);

    }

    private Value v1 = new Value(22);
    private final int i = 4;
    public static final int i3 = 5;
    private final Value v2 = new Value(44);

    private static final Value VAl_3 = new Value (3);

    public static void main(String[] args) {
        B b = new B();
        b.getB();

        Finalizer finalizer = new Finalizer( new Value(3));
        //cannot change an initialized final reference to a new object
//        finalizer.v2 = new Value(4); DOES NOT WORK
        System.out.println(VAl_3);
        //cannot reasign to a final value
//       finalizer.i = 5; DOES NOT WORK

//       Finalizer.i3 = 4; DOES NOT WORK
      //i3 belongs to thje class Finalizer instead of the instance of the class Finalizer which is finalizer
        System.out.println(Finalizer.i3);
    }
}



// upcasting example
class Instrument {
    public Instrument() {
    }

    static void tune(Instrument i) {
        System.out.println("tuning instrument" + i);
    }

    @Override
    public String toString() {
        return "Instrument{}";
    }
}
class Guitar extends Instrument{
    public Guitar() {
    }


    @Override
    public String toString() {
        return "Guitar{}";
    }
}
class Base {
    public Base() {
        System.out.println("ctor BASE");
    }

    void play() {
        System.out.println("playing base");
    }
}

class Derived extends Base {
    public Derived() {
        System.out.println("CTOR DERIVED");
    }

    @Override
    void play() {
        System.out.println("new impl");
//        super.play();
    }
}

class Example {
    public static void main(String[] args) {
        try (Resource resource = new Resource()) {
            // Use the resource within the try block
            resource.doSomething();
        } // The resource will be automatically closed at the end of the try block
    }
}

class Resource implements AutoCloseable {
    public Resource() {
        System.out.println("Resource created");
    }

    public void doSomething() {
        System.out.println("Doing something with the resource");
    }

    @Override
    public void close() {
        System.out.println("Resource closed");
        // Release any resources or perform cleanup
    }
}

public class Practice {

    Practice() {
    }


    void doSomething(String wat) {
        System.out.println("doe dit" + wat);
    }

    public static void main(String[] args) {
        Finalizer finalizer = new Finalizer();
        finalizer.getString();
        finalizer.setString("dododo");
        System.out.println(finalizer.getString());

        Guitar guitar = new Guitar();
        Instrument.tune(guitar);
//        Derived derived = new Derived();
//        derived.play();
//        try (Resource resource = new Resource()){
//            resource.doSomething();
//
//        }
    }

}