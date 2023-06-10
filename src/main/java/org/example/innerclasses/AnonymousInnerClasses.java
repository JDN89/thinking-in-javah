package org.example.innerclasses;

//An anonymous class implementing an interface
public class AnonymousInnerClasses {
}

interface Contents {
    int value();
} ///:~

//: innerclasses/Parcel7.java
// Returning an instance of an anonymous inner class.
class Parcel7 {
    public Contents contents() {
        return new Contents() { // Insert a class definition
            private int i = 11;

            public int value() {
                System.out.println("value of i :" + i);
                return i;
            }
        }; // Semicolon required in this case
    }

    public static void main(String[] args) {
        Parcel7 p = new Parcel7();
        Contents c = p.contents();
        c.value();
    }
} ///:~


//    The anonymous inner-class syntax is a shorthand for:
class Parcel7b {
    class MyContents implements Contents {
        private int i = 11;

        public int value() {
            return i;
        }
    }

    public Contents contents() {
        return new MyContents();
    }

    public static void main(String[] args) {
        Parcel7b p = new Parcel7b();
        Contents c = p.contents();
    }
} ///:~

//    The following code shows what to do if your base class needs a constructor with an argument:
//: innerclasses/Wrapping.java
class Wrapping {
    private int i;

    public Wrapping(int x) {
        i = x;
    }

    public int value() {
        return i;
    }
} ///:~

class Parcel8 {
    public Wrapping wrapping(int x) {
// Base constructor call:
        return new Wrapping(x) { // Pass constructor argument.
            //            Inside the anonymous class, the value() method is overridden, and super.value() is used to invoke the value() method of the superclass (Wrapping). By using super.value()
            @Override
            public int value() {
                return super.value() * 47;
            }
        }; // Semicolon required
    }

    public static void main(String[] args) {
        Parcel8 p = new Parcel8();
        Wrapping w = p.wrapping(10);
        w.value();
    }
} ///:~

//    You can also perform initialization when you define fields in an anonymous class:
// An anonymous inner class that performs
// initialization. A briefer version of Parcel5.java.
class Parcel9 {
    // Argument must be FINAL to use inside
// anonymous inner class:
    public Destination destination(final String dest) {
        return new Destination() {
            private String label = dest;

            public String readLabel() {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel9 p = new Parcel9();
        Destination d = p.destination("Tasmania");
    }
} ///:~

//As long as you’re simply assigning a field, the approach in this example is fine. But what if
//        you need to perform some constructor-like activity? You can’t have a named constructor in
//        an anonymous class (since there’s no name!), but with instance initialization, you can, in
//        effect, create a constructor for an anonymous inner class, like this:
//: innerclasses/AnonymousConstructor.java
// Creating a constructor for an anonymous inner class.
abstract class Base {
    //    in this case, the variable i did nor have to be final. While i is passed to the base constructorthe anonymous class, it is never directly used inside the anonymous class.
    public Base(int i) {
        System.out.println("Base constructor, i = " + i);
    }

    public abstract void f();
}

class AnonymousConstructor {
    public static Base getBase(int i) {
        return new Base(i) {
            {
                System.out.println("Inside instance initializer");
            }

            public void f() {
                System.out.println("In anonymous f()");
            }
        };
    }

    public static void main(String[] args) {
        Base base = getBase(47);
        base.f();
    }
} /* Output:
Base constructor, i = 47
Inside instance initializer
In anonymous f()
*///:~


class Parcel10 {
    public Destination
//    the arguments to
//    destination( ) must be final since they are used within the anonymous class
    destination(final String dest, final float price) {
        return new Destination() {
            private int cost;

            // Instance initialization for each object:
            {
                cost = Math.round(price);
                if (cost > 100)
                    System.out.println("Over budget!");
            }

            private String label = dest;

            public String readLabel() {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel10 p = new Parcel10();
        Destination d = p.destination("Tasmania", 101.395F);
    }
}