package org.example.innerclasses;

public class UsingThisAndNew {
}
class DotThis {
    void f() { System.out.println("DotThis.f()"); }
    public class Inner {
        public DotThis outer() {
//            get access to outer class via .this
            return DotThis.this;
// A plain "this" would be Inner’s "this"
        }
    }
    public Inner inner() { return new Inner(); }
    public static void main(String[] args) {
        DotThis dt = new DotThis();
        DotThis.Inner dti = dt.inner();
        dti.outer().f();
    }
}
// Creating an inner class directly using the .new syntax.
class DotNew {
    public class Inner {}
    public static void main(String[] args) {
        DotNew dn = new DotNew();
//        create new inner class via .new
        DotNew.Inner dni = dn.new Inner();
    }
}
// new example

//--------------------
class Parcel3 {
    class Contents {
        private int i = 11;
        public int value() { return i; }
    }
    class Destination {
        private String label;
        Destination(String whereTo) { label = whereTo; }
        String readLabel() { return label; }
    }
    public static void main(String[] args) {
        Parcel3 p = new Parcel3();
// Must use instance of outer class
// to create an instance of the inner class:
        Parcel3.Contents c = p.new Contents();
        Parcel3.Destination d = p.new Destination("Tasmania");
    }
}