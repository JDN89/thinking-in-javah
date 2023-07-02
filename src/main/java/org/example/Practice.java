package org.example;

public class Practice {
    public static void main(String[] args) {
        var text = """
                split de text op nummer 2. Heb je de text?
                """;

        // Regex pattern to match the position before the first digit
        // Regex pattern to match the position before the first digit
//        String regex = "(?=\\d)";
        String regex = "\\.";
        var result = text.split(regex);
        var count = 1;
        for (String s : result) {
            System.out.printf("The pharse number %d: %s \n", count, s);
            count++;
        }

    }
}