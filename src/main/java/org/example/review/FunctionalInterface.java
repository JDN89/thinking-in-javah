package org.example.review;

import java.util.Arrays;
import java.util.List;

public class FunctionalInterface {
    public static void main(String[] args) {

        // Anonymous inner class to define the calculate method
        Square s = new Square() {
            @Override
            public int calculate(int x) {
                return x * x;
            }
        };
        Calculating.printSquare(s, 4);

        // NEW WAY
        Calculating.printSquare(x -> x * x, 5);
//        Vierkant v = x -> x * x;
//        Calculating.printVierkan(v, 5);

        //other example
        // Using a Predicate functional interface to filter data
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = numbers.stream()
                //check internals of filter -> takes a Predicate: functional interface
                .filter(n -> n % 2 == 0)
                .toList();
    }
}

class Calculating {
    public static void printSquare(Square square, int value) {
        System.out.println(square.calculate(value));
    }
}

interface Square {
    int calculate(int x);
};