package org.example.strings;

public class StringsAreImmutable {
    public static void main(String[] args) {
        String[] words = {"hello", " ", "world", "!"};
        String sentence = "";

        for (String word : words) {
            // voor elke itteratie wordt er een nieuw String object opgebouwd.
            // en de var sentence referenced dan het nieuwe string object
            // het oude String object wordt niet meer gerefereerd door de var sentence en wordt dus opgekuist door de garbage collecter
            // dure operatie want je moet telkens nieuw object opbouwen characters
            sentence += word; // Here, a new String object is created at each iteration
        }

        System.out.println(sentence); // Output: hello world!
    }
}

class StringVsStringBuilder {

    public static void main(String[] args) {
        // Using String
        String s = "";
        for (int i = 0; i < 1000; i++) {
            s += "hello";
            // Creates a new String object each iteration
        }

        // Using StringBuilder
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            sb.append("hello");
            // Modifies the same StringBuilder object
        }
        String result = sb.toString();
    }
}


//: strings/Immutable.java
class Immutable {
    public static String upcase(String s) {
        return s.toUpperCase();
    }

    public static void main(String[] args) {
        String q = "howdy";
        System.out.println(q); // howdy
        String qq = upcase(q);
        System.out.println(qq); // HOWDY
        System.out.println(q); // howdy
    }
}