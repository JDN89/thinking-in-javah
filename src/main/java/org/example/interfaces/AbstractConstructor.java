package org.example.interfaces;

public class AbstractConstructor {
    public static void main(String[] args) {
        Sub sub = new Sub(4);
        sub.abstractMethod();
        sub.finalMethod();

//        anonymous subclass, will be discussed in inner classes(I think)
//        Test test = new Test(5) {
//            @Override
//            public void abstractMethod() {
//
//            }
//        };
//        test.printVaule();

    }

}

abstract class Test {
    public int getValue() {
        return value;
    }

    private int value;

    public Test(int value) {
        this.value = value;
    }

    public abstract void abstractMethod();

    final void finalMethod() {
        System.out.println("calling final method");
    }

    public void printValue() {
        System.out.println(value);
    }
}

class Sub extends Test {
    public Sub(int value) {
        super(value);
    }

    @Override
    public void abstractMethod() {
        System.out.println(getValue());
    }
}