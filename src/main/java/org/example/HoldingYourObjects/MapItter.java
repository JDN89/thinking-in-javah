package org.example.HoldingYourObjects;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapItter {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("Alice", 30);
        map.put("Bob", 20);
        map.put("Pieter", 40);

        // get set of keys
       // set because their can't be duplicate keys -> unique constraint
        Set<String> keys = map.keySet();

//        get values collection because duplicate values are possible
        Collection<Integer> values = map.values();


        for (String key : keys) {
            System.out.println(key);

            for (Integer value: values) {
                System.out.println("value: " + value);
            }
        }
    }
}