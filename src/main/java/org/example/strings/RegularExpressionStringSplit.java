package org.example.strings;

import java.util.Arrays;

public class RegularExpressionStringSplit {
}

// JAVA 17 example of class Splitting:
class Java17Splitting {

    public static String knights = """
        Then, when you have found the shrubbery, you must
        cut down the mightiest tree in the forest...
        with... a herring!""";

    public static void split(String regex) {
        var splitResult = knights.split(regex);
        System.out.println(String.format("Split by '%s': %s", regex, Arrays.toString(splitResult)));
    }

    public static void main(String[] args) {
        split(" ");    // Doesn’t have to contain regex chars
        split("\\W+"); // Non-word characters
        split("n\\W+"); // ‘n’ followed by non-word characters
    }
}

class Splitting {
    public static String knights =
            "Then, when you have found the shrubbery, you must " +
                    "cut down the mightiest tree in the forest... " +
                    "with... a herring!";
    public static void split(String regex) {
        System.out.println(
                Arrays.toString(knights.split(regex)));
    }
    public static void main(String[] args) {
        split(" "); // Doesn’t have to contain regex chars
        split("\\W+"); // Non-word characters
        split("n\\W+"); // ‘n’ followed by non-word characters
        // REPLACE EXAMPLE
        System.out.println(knights.replaceAll("shrubbery|tree|herring","banana"));
    }
}