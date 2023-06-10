package org.example.innerclasses;


//The first example shows the creation of an entire class within the scope of a method (instead
//        of the scope of another class). This is called a local inner class:
public class InnerClassesInMethodsAndScopes {
}

//: innerclasses/Destination.java
interface Destination {
    String readLabel();
} ///:~

class Parcel5 {
    public Destination destination(String s) {
        class PDestination implements Destination {

            private String label;
            private PDestination(String whereTo) {
                label = whereTo;
            }
            public String readLabel() { return label; }
        }
        return new PDestination(s);
    }
    public static void main(String[] args) {
        Parcel5 p = new Parcel5();
        Destination d = p.destination("Tasmania");
    }


} ///:~


class Parcel6 {
    private void internalTracking(boolean b) {
        if(b) {
            class TrackingSlip {
                private String id;
                TrackingSlip(String s) {
                    id = s;
                }
                String getSlip() { return id; }
            }
            TrackingSlip ts = new TrackingSlip("slip");
            String s = ts.getSlip();
            System.out.println(s);
        }
// Can’t use it here! Out of scope:
//! TrackingSlip ts = new TrackingSlip("x");
    }
    public void track() { internalTracking(true); }
    public static void main(String[] args) {
        Parcel6 p = new Parcel6();
        p.track();
    }
} ///:~