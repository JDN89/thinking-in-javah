package org.example.interfaces;

public class LessConfusingExampleCompareToMultiInh {
}
interface Shapeh {
    void draw();
}

interface Colorable {
    void setColor(String color);
}

interface Resizable {
    void resize(int width, int height);
}

interface Drawable extends Shapeh, Colorable, Resizable {
    void render();
}

class Rectanglee implements Drawable {
    public void draw() {
        System.out.println("Drawing rectangle");
    }

    public void setColor(String color) {
        System.out.println("Setting color: " + color);
    }

    public void resize(int width, int height) {
        System.out.println("Resizing to width: " + width + ", height: " + height);
    }

    public void render() {
        System.out.println("Rendering rectangle");
    }
}

class InterfaceInheritanceExample {
    public static void main(String[] args) {
        Rectanglee rectangle = new Rectanglee();
        rectangle.draw();
        rectangle.setColor("Blue");
        rectangle.resize(100, 150);
        rectangle.render();
    }
}