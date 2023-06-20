package org.example.HoldingYourObjects;

import java.util.*;

public class AddingGroupsOfElements {
}

class AddingGroups {
    public static void main(String[] args) {
        Collection<Integer> collection =
                new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        Integer[] moreInts = {6, 7, 8, 9, 10};
        Arrays.stream(moreInts).iterator().forEachRemaining(i -> System.out.println("[]: " + i));
        collection.addAll(Arrays.asList(moreInts));
// Runs significantly faster, but you can’t
// construct a Collection this way:
        Collections.addAll(collection, 11, 12, 13, 14, 15);
        Collections.addAll(collection, moreInts);
// Produces a list "backed by" an array:
        List<Integer> list = Arrays.asList(16, 17, 18, 19, 20);
        list.set(1, 99); // OK -- modify an element
// list.add(21); // Runtime error because the
// underlying array cannot be resized.
// OUTPUT OF Arrays.asList() is cast to an array -> so you can't resize
        list.iterator().forEachRemaining(e -> System.out.println(e));
    }
}