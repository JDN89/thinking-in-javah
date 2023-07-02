package org.example.typeinformation;

public class EnhancedInstaneOfPatternMatching {

    //check of incomming Object is an isntance of the String class
    public static void patternMatcherJava8(Object name) {
        if (name instanceof String) {
            String s = (String) name;
            System.out.println(s.toUpperCase());
        }
    }

    public static void patternMatcherJava17(Object fame) {
        if (fame instanceof String s) {
            System.out.println(s.toUpperCase());
        }
    }

    public static void main(String[] args) {
        patternMatcherJava8("Jan");
        patternMatcherJava17("fabuloso");
    }

}