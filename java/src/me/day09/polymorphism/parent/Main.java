package me.day09.polymorphism.parent;

public class Main {
    public static void main(String[] args) {
        Shape shape = new Circle();
        System.out.println(shape.getCenterPoint());
        System.out.println(((Circle)shape).getRadius());

        // Shape: centerPoint
        // Circle: centerPoint, radius

        Circle circle = (Circle) new Shape();
        System.out.println(circle.getCenterPoint());
        System.out.println(circle.getRadius());


        // Shape
        //  - Circle
        //  - Rectangle
        //  - Triangle
    }
}
