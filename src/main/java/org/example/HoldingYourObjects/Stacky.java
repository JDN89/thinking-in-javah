package org.example.HoldingYourObjects;

import java.util.Stack;

public class Stacky {
}
// LIFO
class StackExample {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Pushing elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println("Stack: " + stack); // Stack: [10, 20, 30, 40]

        // Peeking the top element
        int topElement = stack.peek();
        System.out.println("Top element: " + topElement); // Top element: 40

        // Popping elements from the stack
        int poppedElement = stack.pop();
        System.out.println("Popped element: " + poppedElement); // Popped element: 40

        System.out.println("Stack after pop: " + stack); // Stack after pop: [10, 20, 30]

        // Checking if the stack is empty
        boolean isEmpty = stack.isEmpty();
        System.out.println("Is stack empty? " + isEmpty); // Is stack empty? false

        // Getting the size of the stack
        int size = stack.size();
        System.out.println("Stack size: " + size); // Stack size: 3
    }
}
