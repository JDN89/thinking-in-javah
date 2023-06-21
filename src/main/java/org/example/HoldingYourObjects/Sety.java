package org.example.HoldingYourObjects;

import java.util.HashSet;
import java.util.Set;
public class Sety {
}

class SetExample {
    public static void main(String[] args) {
        // Create a HashSet
        Set<Integer> numberSet = new HashSet<>();

        // Add elements to the Set
        numberSet.add(10);
        numberSet.add(20);
        numberSet.add(30);
        numberSet.add(40);
        numberSet.add(50);

        // Try adding a duplicate element
        numberSet.add(20);

        // Print the Set
        System.out.println("Number Set: " + numberSet);

        // no specific order
        // Test for membership
        System.out.println("Is 30 present? " + numberSet.contains(30));
        System.out.println("Is 60 present? " + numberSet.contains(60));
    }
}
