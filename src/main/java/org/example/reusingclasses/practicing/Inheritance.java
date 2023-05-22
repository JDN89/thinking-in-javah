package org.example.reusingclasses.practicing;


class Base {

    //initializer to 5 is redundant because you allready assign to i via ctor
    //which overrides the i = 5
    public int i = 5;
    private int b = 6;

    //    Final fields are not typically placed into the constructor of a class
//    because they are intended to be assigned once and remain constant throughout the lifetime of the object.
//    By declaring a field as final, you ensure that its value cannot be changed after it is initialized.
    public final int c = 7;

    public Base(int i, int b) {
        this.i = i;
        this.b = b;
    }

    public final String string = "test";

    void doSomething() {
        System.out.println("doing stuff");
    }

    // you can only access the private field via the derived class
    //via getters and setters

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}

class Derived extends Base {

    public Derived(int i, int b) {
        super(i, b);
    }

    void doSomething() {
        super.doSomething();
        System.out.println("doing somehting else");
    }

}

public class Inheritance {
    public static void main(String[] args) {
        Derived d = new Derived(4, 6);
        d.doSomething();
        System.out.println(d.i);
        System.out.println(d.getB());
        //cannot assign a value to a final variable
//        d.c = 9;

    }
}