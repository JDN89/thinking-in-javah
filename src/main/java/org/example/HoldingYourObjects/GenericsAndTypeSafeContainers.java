package org.example.HoldingYourObjects;

import java.util.ArrayList;

public class GenericsAndTypeSafeContainers {
}

class Apple {
    private static long counter;
    private final long id = counter++;
    public long id() { return id; }
}
class Orange {}

class ApplesAndOrangesWithGenerics {
    public static void main(String[] args) {
        ArrayList<Apple> apples = new ArrayList<Apple>();
        for(int i = 0; i < 3; i++)
            apples.add(new Apple());
// Compile-time error:
// apples.add(new Orange());
        for(int i = 0; i < apples.size(); i++)
            System.out.println(apples.get(i).id());
// Using foreach:
        for(Apple c : apples)
            System.out.println(c.id());
    }
}

//============== UPCASTING(upcasting refers to the process of treating an object of a subclass as an object of its superclass.) EXAMPLE

class GrannySmith extends Apple {}
class Gala extends Apple {}
class Fuji extends Apple {}
class Braeburn extends Apple {}
class GenericsAndUpcasting {
    public static void main(String[] args) {
        ArrayList<Apple> apples = new ArrayList<Apple>();
        apples.add(new GrannySmith());
        apples.add(new Gala());
        apples.add(new Fuji());
        apples.add(new Braeburn());
        for(Apple c : apples)
            System.out.println(c);
    }
}