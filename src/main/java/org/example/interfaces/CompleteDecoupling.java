package org.example.interfaces;

import java.util.Arrays;


public class CompleteDecoupling {
    public static void main(String [] args) {

    }
}

class Processor {
    public String name() {
        return getClass().getSimpleName();
    }

    Object process(Object input) {
        return input;
    }
}

class Upcase extends Processor {
    String process(Object input) { // Covariant return
        return ((String) input).toUpperCase();
    }
}

class Downcase extends Processor {
    String process(Object input) {
        return ((String) input).toLowerCase();
    }
}

class Splitter extends Processor {
    String process(Object input) {
// The split() argument divides a String into pieces:
        return Arrays.toString(((String) input).split(" "));
    }
}

class Apply {
    public static void process(Processor p, Object s) {
        System.out.println("Using Processor " + p.name());
        System.out.println(p.process(s));
    }

    public static String s =
            "Disagreement with beliefs is by definition incorrect";

    public static void main(String[] args) {
        process(new Upcase(), s);
        process(new Downcase(), s);
        process(new Splitter(), s);
    }
}

class Waveform {
    private static long counter;
    private final long id = counter++;
    public String toString() { return "Waveform " + id; }
}
class Filter {
    public String name() {
        return getClass().getSimpleName();
    }
    public Waveform process(Waveform input) { return input; }
}