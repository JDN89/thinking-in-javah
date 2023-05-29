package org.example.reusingclasses.polymorphism;

public class Privateer {
    public static void main(String[] args) {
        MrPrivate deriver = new Deriver();
//        deriver.f("test");
    }
}

class MrPrivate {
    public MrPrivate() {
    }

    private void f(String s) {
        System.out.println(s + "not overloaded");
    }
}

class Deriver extends MrPrivate {
    public Deriver() {
    }

    public void f(String s) {
        System.out.println("this is new f");
    }
}