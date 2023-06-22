package org.example.HoldingYourObjects;

import java.util.HashMap;
        import java.util.Map;
        import java.util.Random;

public class Mapy {
}
class RandomDistribution {

    public static void main(String[] args) {

        // Create a new Random object
        Random random = new Random();

        // Create a HashMap to keep track of the distribution of numbers
        Map<Integer, Integer> distributionMap = new HashMap<>();

        // Number of random numbers to generate
        int numberOfRandomNumbers = 1000000;

        // Loop to generate random numbers
        for (int i = 0; i < numberOfRandomNumbers; i++) {
            // Generate a random number between 0 and 9 (inclusive)
            int randomNumber = random.nextInt(10);

            // If the number is already in the map, increment its count
            // otherwise, put it in the map with a count of 1
            distributionMap.put(randomNumber, distributionMap.getOrDefault(randomNumber, 0) + 1);
        }

        // Display the distribution
        for (Map.Entry<Integer, Integer> entry : distributionMap.entrySet()) {
            System.out.println("Number " + entry.getKey() + " appeared " + entry.getValue() + " times.");
        }
    }
}