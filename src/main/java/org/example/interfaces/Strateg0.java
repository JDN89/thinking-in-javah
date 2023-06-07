package org.example.interfaces;

public class Strateg0 {
    public static void main(String[] args) {
        Generaal generaal = new Generaal();
        Kapitein kapitein = new Kapitein();

        Context contextA = new Context(generaal);
        contextA.voerStrategieUit();
        Context context = new Context(kapitein);
        context.voerStrategieUit();
        context.setStrategy(generaal);
        context.setStrategy(kapitein);

    }
}

interface Strategy {
    void execute();
}

class Generaal implements Strategy {

    @Override
    public void execute() {
        System.out.println("Ik ben de man");
    }
}

class Kapitein implements Strategy {

    @Override
    public void execute() {
        System.out.println("Ik ben de capitan eej");
    }
}

class Context {
    private Strategy strategy;

    //    set strategy via ctor
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    //    set strategy via method
    public void setStrategy(Strategy strategy) {
        strategy.execute();
    }

    void voerStrategieUit() {
        strategy.execute();
    }
}