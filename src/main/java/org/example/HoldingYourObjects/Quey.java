package org.example.HoldingYourObjects;

import java.util.*;

class QueueDemo {

    // Define a method called printQ that takes a Queue of any type (denoted by <?>) as an argument
    public static void printQ(Queue<?> queue) {
        // While the queue is not empty (peek() returns null when the queue is empty)
        while (queue.peek() != null) {
            // Remove the element at the front of the queue and print it followed by a space
            // (remove() both retrieves and removes the head of the queue)
            System.out.print(queue.remove() + " ");
        }
        // Print a newline character to move to the next line after printing all elements of the queue
        System.out.println();
    }


    // The main method - this is the entry point of the program
    public static void main(String[] args) {
        // Create a Queue of Integers using a LinkedList and assign it to the variable named queue
        Queue<Integer> queue = new LinkedList<>();
        // Create a Random object with a seed of 47, to generate random numbers
        //When you create a Random object with a specific seed, it will produce the same sequence of random numbers every time the program is run.
        // This can be useful in testing or debugging, where you want your code to be deterministic.
        Random rand = new Random(47);

        // Loop 10 times
        for (int i = 0; i < 10; i++) {
            // Generate a random number between 0 and (i + 9), and add it to the queue
            // (offer() inserts the specified element into the queue)
            queue.offer(rand.nextInt(i + 10));
        }

        // Call the printQ method to print the contents of the queue
        printQ(queue);

        // Create a Queue of Characters using a LinkedList and assign it to the variable named qc
        Queue<Character> qc = new LinkedList<>();
        // Loop through each character in the string "Brontosaurus"
        for (char c : "Brontosaurus".toCharArray()) {
            // Add each character to the character queue
            qc.offer(c);
        }

        // Call the printQ method to print the contents of the character queue
        printQ(qc);
    }
}

class PriorityQueueDemo {

    public static void main(String[] args) {
        // Create a PriorityQueue of integers with natural ordering.
        // This means the lowest integer has the highest priority.
        PriorityQueue<Integer> naturalOrderQueue = new PriorityQueue<>();

        // Add elements to the queue
        naturalOrderQueue.offer(5);
        naturalOrderQueue.offer(1);
        naturalOrderQueue.offer(3);

        // Print and remove elements from the queue.
        // Elements will be removed in ascending order (1, 3, 5).
        while (!naturalOrderQueue.isEmpty()) {
            System.out.print(naturalOrderQueue.poll() + " ");
        }
        System.out.println();

        // Create a PriorityQueue of integers with a custom comparator.
        // This comparator ensures the highest integer has the highest priority.
        PriorityQueue<Integer> customOrderQueue = new PriorityQueue<>(Comparator.reverseOrder());

        // Add elements to the queue
        customOrderQueue.offer(5);
        customOrderQueue.offer(1);
        customOrderQueue.offer(3);

        // Print and remove elements from the queue.
        // Elements will be removed in descending order (5, 3, 1).
        while (!customOrderQueue.isEmpty()) {
            System.out.print(customOrderQueue.poll() + " ");
        }
        System.out.println();

        // Example with objects - Priority based on string length
        PriorityQueue<String> stringQueue = new PriorityQueue<>(Comparator.comparingInt(String::length));

        // Add elements to the queue
        stringQueue.offer("short");
        stringQueue.offer("very long string");
        stringQueue.offer("medium");

        // Print and remove elements from the queue.
        // Elements will be removed based on the length of the string (ascending order).
        while (!stringQueue.isEmpty()) {
            System.out.print(stringQueue.poll() + ", ");
        }
        System.out.println();
    }
}


public class Quey {
}
