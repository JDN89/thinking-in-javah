package org.example.functionalinterfaces.buttonEvent;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

//  excatly one abstract method
// first class citizens (treat functions as objects)
public class FuncTown {
    public static void main(String[] args) {
        System.out.println("Example 1: Using a lambda expression");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.stream().filter(n -> n % 2 == 0).forEach(System.out::println);
        System.out.println("------------");
        System.out.println("Example 2: Using a predefined functional interface");
        Predicate<Integer> isOdd = n -> n % 2 != 0; // Creating a Predicate using a lambda expression
        numbers.stream().filter(isOdd).forEach(System.out::println);


        System.out.println("ReverseOrder comparator example");
        List<Integer> unOrderedNumbers = Arrays.asList(2, 6, 3, 9, 4, 10);
        Collections.sort(unOrderedNumbers, Comparator.reverseOrder());
        System.out.println(unOrderedNumbers);
        Collections.sort(unOrderedNumbers, Comparator.comparingInt(n -> n * n));
        System.out.println(unOrderedNumbers);

        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");
//        Collections.sort(strings,(s1,s2) -> Integer.compare(s1.length(),s2.length()));
        Collections.sort(strings, Comparator.comparingInt(String::length));
        System.out.println(strings);

    }
}