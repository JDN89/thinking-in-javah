package org.example.innerclasses;

public class practice {
    public static void main(String[] args) {
        Outer outer = new Outer("printing");
        outer.create().print();
    }
}

class Outer {
    private String accessible;

    public Outer(String accessible) {
        this.accessible = accessible;
    }
    Inner create () {
       return new Inner();
    };

    class Inner {

        void print() {
            System.out.println(accessible);
        }
    }
}