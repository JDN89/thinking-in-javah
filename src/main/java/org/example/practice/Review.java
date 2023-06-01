package org.example.practice;

public class Review {

    public static void main(String[] args) {

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