package org.example.interfaces;

public class Interfaker {
    static void printArea(Shape shape) {
        double area = shape.calculateArea();
        System.out.println("Area: " + area);
    }

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(4, 5);
        Circle circle = new Circle(6);
        Interfaker.printArea(rectangle);
        Interfaker.printArea(circle);

    }

}

interface Shape {
    double calculateArea();
}

class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return height * width;
    }
}

class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}