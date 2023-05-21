package org.example.reusingclasses;


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