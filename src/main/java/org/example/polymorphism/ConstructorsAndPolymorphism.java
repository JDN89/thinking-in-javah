package org.example.polymorphism;

public class ConstructorsAndPolymorphism {
    public static void main(String[] args) {

        new RoundGlyph(5);
    }
}

class Glyph {
    void draw() {
        System.out.println("Glyph.draw()");
    }

    Glyph() {
        System.out.println("Glyph() before draw()");
        draw();
        System.out.println("Glyph() after draw()");
    }
}

class RoundGlyph extends Glyph {
    private int radius = 1;

    RoundGlyph(int r) {
        radius = r;
        System.out.println("RoundGlyph.RoundGlyph(), radius = " + radius);
    }

    void draw() {
        System.out.println("RoundGlyph.draw(), radius = " + radius);
    }
}
//check output
//The storage allocated for the object is initialized to binary zero before anything else
//happens. -> not even 1
//.The base-class constructors are called as described previously. At this point, the
//        overridden draw( ) method is called (yes, before the RoundGlyph constructor is
//        called), which discovers a radius value of zero, due to Step 1.