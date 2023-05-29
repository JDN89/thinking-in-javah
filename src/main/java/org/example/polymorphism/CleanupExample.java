package org.example.polymorphism;

public class CleanupExample {
    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.dipsose();


    }
}

class Sup {
    void dipsose() {
        System.out.println("don;t forget to call the base dispose method when you override the cleanup logic from the base class!!");
    }
}

class Sub extends Sup {
    void dipsose() {
        System.out.println("some sub cleanup logic");
        super.dipsose();
    }
}