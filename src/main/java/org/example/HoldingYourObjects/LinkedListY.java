package org.example.HoldingYourObjects;

import java.util.LinkedList;

class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();

        // Adding elements to the LinkedList
        linkedList.add("Apple");
        linkedList.addFirst("Banana");
        linkedList.addLast("Orange");

        System.out.println(linkedList); // [Banana, Apple, Orange]

        // Retrieving elements
        String first = linkedList.getFirst();
        String last = linkedList.getLast();
        String element = linkedList.element();

        System.out.println("First: " + first); // Banana
        System.out.println("Last: " + last); // Orange
        System.out.println("Element: " + element); // Banana

        // Removing elements
        String removedFirst = linkedList.removeFirst();
        String removedLast = linkedList.removeLast();
        String removed = linkedList.remove();

        System.out.println("Removed First: " + removedFirst); // Banana
        System.out.println("Removed Last: " + removedLast); // Orange
        System.out.println("Removed Element: " + removed); // Apple

        System.out.println(linkedList); // []

        // Adding elements again
        linkedList.addFirst("Mango");
        linkedList.addLast("Grapes");
        linkedList.offer("Pineapple");

        System.out.println(linkedList); // [Mango, Grapes, Pineapple]

        // Removing last element
        String removedLastElement = linkedList.removeLast();

        System.out.println("Removed Last Element: " + removedLastElement); // Pineapple

        System.out.println(linkedList); // [Mango, Grapes]

    }
}
public class LinkedListY {
}
