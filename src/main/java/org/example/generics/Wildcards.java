package org.example.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Wildcards {
}
class Fruit {}
class Apple extends Fruit {}
class Jonathan extends Apple {}
class Orange extends Fruit {}
class CovariantArrays {
    public static void main(String[] args) {
        Fruit[] fruit = new Apple[10];
        fruit[0] = new Apple(); // OK
        fruit[1] = new Jonathan(); // OK
// Runtime type is Apple[], not Fruit[] or Orange[]:
        try {
// Compiler allows you to add Fruit:
            fruit[0] = new Fruit(); // ArrayStoreException
        } catch(Exception e) { System.out.println(e); }
        try {
// Compiler allows you to add Oranges:
            fruit[0] = new Orange(); // ArrayStoreException
        } catch(Exception e) { System.out.println(e); }
    }
}

//    If you need to get values out of a structure and you don't know its exact type parameter, use extends (producer).

class GenericsAndCovariance {
    public static void main(String[] args) {
// Wildcards allow covariance:
        List<? extends Fruit> flist = new ArrayList<Apple>();
// Compile Error: can’t add any type of object:
// flist.add(new Apple());
// flist.add(new Fruit());
// flist.add(new Object());
//        flist.add(null); // Legal but uninteresting
// We know that it returns at least Fruit:
        Fruit f = flist.get(0);
    }
}

//If you need to put values into a structure and you don't know its exact type parameter, use super (consumer).
//So, if you want to add elements to your list, you should either declare it with a specific type, or use a lower-bounded wildcard (List<? super Apple>), which allows you to add Apple and its subtypes to the list.
class SuperTypeWildcards {
    static void writeTo(List<? super Apple> apples) {
        apples.add(new Apple());
        apples.add(new Jonathan());
// apples.add(new Fruit()); // Error
    }
}