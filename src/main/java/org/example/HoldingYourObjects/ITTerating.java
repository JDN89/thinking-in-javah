package org.example.HoldingYourObjects;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ITTerating {
}


class IteratorExample {
    public static void main(String[] args) {
        List<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");

        Iterator<String> iterator = colors.iterator();

        // hasNext() and next()
        while (iterator.hasNext()) {
            String color = iterator.next();
            System.out.println(color);
        }

        // remove()
        iterator = colors.iterator(); // Reset the iterator

        while (iterator.hasNext()) {
            String color = iterator.next();
            if (color.equals("Green")) {
                iterator.remove();
            }
        }

        System.out.println(colors); // [Red, Blue]

        // forEachRemaining()
        iterator = colors.iterator(); // Reset the iterator

        //for each remaining element preform said action
        iterator.forEachRemaining(System.out::println);
    }
}

class ListIteratorExample {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");

        ListIterator<String> listIterator = fruits.listIterator();

        // hasNext() and next()
        while (listIterator.hasNext()) {
            String fruit = listIterator.next();
            System.out.println(fruit);
        }

        System.out.println("go backwards");
        // hasPrevious() and previous()
        while (listIterator.hasPrevious()) {
            String fruit = listIterator.previous();
            System.out.println(fruit);
        }

        // add()
        listIterator = fruits.listIterator(); // Reset the iterator

        while (listIterator.hasNext()) {
            String fruit = listIterator.next();
            if (fruit.equals("Banana")) {
                listIterator.add("Mango");
            }
        }

        System.out.println(fruits); // [Apple, Mango, Banana, Orange]

        // set()
        listIterator = fruits.listIterator(); // Reset the iterator

        while (listIterator.hasNext()) {
            String fruit = listIterator.next();
            if (fruit.equals("Banana")) {
                listIterator.set("Pineapple");
            }
        }

        System.out.println(fruits); // [Apple, Mango, Pineapple, Orange]

        // remove()
        listIterator = fruits.listIterator(); // Reset the iterator

        while (listIterator.hasNext()) {
            String fruit = listIterator.next();
            if (fruit.equals("Mango")) {
                listIterator.remove();
            }
        }

        System.out.println(fruits); // [Apple, Pineapple, Orange]
    }
}

