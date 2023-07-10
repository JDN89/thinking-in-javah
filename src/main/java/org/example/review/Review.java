package org.example.review;

public class Review {
    public static void main(String[] args) {
        Greeting englishGreeting = new EnglishGreeting();
        Greeting spanishGreeting = new SpanishGreeting();
        greet(spanishGreeting, "Jan");
    }

    public static void greet(Greeting greeting, String name) {
        greeting.sayHello(name);
    }
}

interface Greeting {
    void sayHello(String name);
}

class EnglishGreeting implements Greeting {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello " + name);
    }
}

class SpanishGreeting implements Greeting {

    @Override
    public void sayHello(String name) {
        System.out.println("Hola " + name);
    }
}