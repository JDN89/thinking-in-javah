package org.example.reusingclasses.polymorphism;


public class Upcaster {
    public static void main(String[] args) {
        //this is upcasting
        // you cast a guitar to its base class Instrument
        //WHy? instead of having to write a tuning method for each specific type of instrument
        // you can write just a method for the base class and polymorphism takes care of the rest
        Guitar guitar = new Guitar();
        Music.tune(guitar);

    }
}

class Instrument {

    public void play(char c) {
        System.out.println("chord" + c);
    }

    @Override
    public String toString() {
        return "Instrument{}";
    }
}

class Guitar extends Instrument {
    public void play(String s) {
        System.out.println("playing song" + s);
    }
}

class Music {
    static void tune(Instrument i) {
        System.out.println("tuning "  + i);
    }
}