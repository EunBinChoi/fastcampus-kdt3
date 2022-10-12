package me.day09.practice.practice07;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(new Point(3, 5), 2);
        System.out.println("circle = " + circle);
        System.out.println("circle.calculateArea() = " + circle.calculateArea());
        System.out.println();

        circle.translate(3, 5);
        System.out.println("translated circle = " + circle);
        System.out.println("circle.calculateArea() = " + circle.calculateArea());
        System.out.println();

        circle.scale(2);
        System.out.println("scaled circle = " + circle);
        System.out.println("circle.calculateArea() = " + circle.calculateArea());

    }
}
