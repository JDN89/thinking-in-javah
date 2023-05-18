package org.example.reusingclasses;

class Game {
    Game(int i) {
        System.out.println("Game constructor");
        System.out.println("game" + i);
    }
}

class BoardGame extends Game {
    BoardGame(int i) {
        super(i);
        System.out.println("BoardGame constructor");
        System.out.println("boardgame " + i);
    }
}

public class Chess extends BoardGame {
    Chess() {
        // If your base class has arguments you must make explicit calls to the base class ctor via the super keyword
        //withing you current ctor
        super(11);
        System.out.println("Chess constructor");
    }

    public static void main(String[] args) {
        Chess x = new Chess();
    }
} /* Output:
Game constructor
BoardGame constructor
Chess constructor
*///:~