package org.example.interfaces;

public class Temptation {
}


// GENOEG VOORBEELDEN IN HERACLES
abstract class AbstractTemplate {

    // Template method -> FINAL ZO JE KAN het niet overschrijven -> zal voor al de sublasses op dezelfde manier werken
    public final void templateMethod() {
        step1();
        step2();
        step3();
        additionalStep(); // Optional hook method
    }

    // Abstract methods to be implemented by subclasses -> VERPLICHT
    protected abstract void step1();

    protected abstract void step2();

    protected abstract void step3();

    // Optional hook method
    protected void additionalStep() {
        // Default implementation does nothing
    }
}