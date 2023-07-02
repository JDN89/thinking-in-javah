package org.example.strings;

import java.io.PrintStream;
import java.util.Formatter;

public class FormattingOutput {
    public static void main(String[] args) {
        int x = 5;
        double y = 5.332542;
// The old way:
        System.out.println("Row 1: [" + x + " " + y + "]");
// The new way:
        System.out.format("Row 1: [%d %f]\n", x, y);
// or
        System.out.printf("Row 1: [%d %f]\n", x, y);
    }
}

//EXAMPLE OF THE FORMATTER UTIL CLASS
class Turtle {
    private String name;
    private Formatter f;

    public Turtle(String name, Formatter f) {
        this.name = name;
        this.f = f;
    }

    public void move(int x, int y) {
        f.format("%s The Turtle is at (%d,%d)\n", name, x, y);
    }

    public static void main(String[] args) {
        PrintStream outAlias = System.out;
        Turtle tommy = new Turtle("Tommy",
                new Formatter(System.out));
        Turtle terry = new Turtle("Terry",
                new Formatter(outAlias));
        tommy.move(0, 0);
        terry.move(4, 8);
        tommy.move(3, 4);
        terry.move(2, 5);
        tommy.move(3, 3);
        terry.move(3, 3);
    }
}

//EXAMPLE OF FORMATTER SPECIFIERS: WIDT AND PRECISION
class Receipt {
    private double total = 0;
    private Formatter f = new Formatter(System.out);

    public void printTitle() {
        f.format("%-15s %5s %10s\n", "Item", "Qty", "Price");
        f.format("%-15s %5s %10s\n", "----", "---", "-----");
    }

    /*
            %-15.15s specifies a string that is left-justified and takes up to 15 characters.
        %5d specifies an integer that is right-justified and takes up to 5 characters.
        %10.2f specifies a floating-point number that is right-justified, takes up to 10 characters, and has 2 digits after the decimal point.
    */
    public void print(String name, int qty, double price) {
        f.format("%-15.15s %5d %10.2f\n", name, qty, price);
        total += price;
    }

    public void printTotal() {
        f.format("%-15s %5s %10.2f\n", "Tax", "", total * 0.06);
        f.format("%-15s %5s %10s\n", "", "", "-----");
        f.format("%-15s %5s %10.2f\n", "Total", "",
                total * 1.06);
    }

    public static void main(String[] args) {
        Receipt receipt = new Receipt();
        receipt.printTitle();
        receipt.print("Jack’s Magic Beans", 4, 4.25);
        receipt.print("Princess Peas", 3, 5.1);
        receipt.print("Three Bears Porridge", 1, 14.29);
        receipt.printTotal();
    }
}

//Another formatter exmaple
class FormattingOutputWithFormatterExample {

    public static void main(String[] args) {
        // Create a Formatter that outputs to the console
        Formatter formatter = new Formatter(System.out);

        // Print table header
        formatter.format("%s | %s | %s\n", "Number", "Square", "Cube");

        // Loop through numbers 1 to 5
        for (int i = 1; i <= 5; i++) {
            // Calculate square and cube
            int square = i * i;
            int cube = i * i * i;

            // Format and print the row using Formatter
            formatter.format("%6d | %6d | %4d\n", i, square, cube);
        }

        // Close the formatter
        formatter.close();
    }
}