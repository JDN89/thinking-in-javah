package org.example.polymorphism;

public class ConstructorsAndPolymorphism {
    public static void main(String[] args) {

       Glyph myRoundGlyph =  new RoundGlyph(5);
//       myRoundGlyph.drawCalledOutsideCtor();


    }
}

class Glyph {
    void draw() {
        System.out.println("Glyph.draw()");
    }
    void speak() {
        System.out.println("volume is standard");
    }

//    void drawCalledOutsideCtor() {
//        System.out.println("Glyph.draw outside ctor");
//    }

    Glyph() {
        System.out.println("Glyph() before draw()");
        draw();
        speak();
        System.out.println("Glyph() after draw()");
    }
}

class RoundGlyph extends Glyph {
    private int radius = 1;
    private String voluma = "loud";

    RoundGlyph(int r) {
        radius = r;
        System.out.println("RoundGlyph.RoundGlyph(), radius = " + radius);
        System.out.printf("speaking volume is " + voluma);
    }

    @Override
    void draw() {
        System.out.println("RoundGlyph.draw(), radius = " + radius);
    }

    @Override
    void speak() {
        System.out.println("Speaking " + voluma);
    }

//    @Override
//    void drawCalledOutsideCtor() {
//        System.out.println("draw outside ctor, radius: " + radius);
//    }
}
//check output
//The storage allocated for the object is initialized to binary zero before anything else
//happens. -> not even 1
//.The base-class constructors are called as described previously. At this point, the
//        overridden draw( ) method is called (yes, before the RoundGlyph constructor is
//        called), which discovers a radius value of zero, due to Step 1.