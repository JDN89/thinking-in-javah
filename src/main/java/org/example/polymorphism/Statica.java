package org.example.polymorphism;

public class Statica {
    public static void main(String[] args) {
        Base base  = new Derived(4);
        Derived de = new Derived(4);
        //you have access to the public fields of the base class
        //but normally all fields are private and you only get access to the fields via the getters and setters of the base class
        de.s = "hello";
//        de.t = 5;

//        base.d();
//        Base.f();
//        Derived.f();
        base.f();


    }
}

class Base {

    private int t;
    public String s;

    public Base(int t) {
        this.t = t;
    }

    static void f() {
        System.out.println("static method from base class");
    }
    public void d() {
        System.out.println("public base method");
    }

}
class Derived extends Base {
    Derived(int t) {
        super(t);
    }

    public static void f() {
        System.out.println("static method from sub class");
    }
    public void d () {
        System.out.println("overriden d");
    }
}