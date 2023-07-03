package org.example.practice;

import java.lang.reflect.Method;

public class Review {

    public static void main(String[] args) {
/*
        String s = "hello";
        Class<?> clazz = s.getClass();
        System.out.println("Class name: " + clazz.getName());
*/

        Class<?> clazz = String.class;
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }
}

class Base {

    //  you can't create a setter because random is final
   private final String random;
   private String mutable;

    public Base(String random, String mutable) {
        this.random = random;
        this.mutable = mutable;
    }

    public String getRandom() {
        return random;
    }

    public String getMutable() {
        return mutable;
    }

    public void setMutable(String mutable) {
        this.mutable = mutable;
    }
}

class Derived extends Base {
    public Derived(String random, String mutable) {
        super(random, mutable);
    }
}