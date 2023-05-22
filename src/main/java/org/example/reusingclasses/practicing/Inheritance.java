package org.example.reusingclasses.practicing;


class Base{

    public final String string = "test";
    void doSomething()
    {
        System.out.println("doing stuff");
    }

}
class Derived extends Base{
    void doSomething() {
        super.doSomething();
        System.out.println("doing somehting else");
    }

}

public class Inheritance {
    public static void main(String[] args) {
        Derived d = new Derived();
        d.doSomething();

    }
}