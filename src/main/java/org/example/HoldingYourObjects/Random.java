package org.example.HoldingYourObjects;

import java.util.*;

public class Random {
    public static void main(String[] args) {
        var appels = List.of("appel1", "appel2", "appel3");
        Iterator<String> iterator = appels.listIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        LinkedList<Integer> integers = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        Iterator<Integer> integerIterator = integers.iterator();

        var total = 0;
        while (integerIterator.hasNext()) {
            total += integerIterator.next();
            System.out.println(total);
        }
        Map<String, Integer> map = new HashMap<>();
        map.put("Alice", 34);
        map.put("bAlice", 55);
        map.put("cAlice", 66);
        for (Map.Entry<String, Integer> entry : map.entrySet())
            System.out.println(entry);
        map.forEach((key, value) -> System.out.println(key + " age: " + value));
    }


}