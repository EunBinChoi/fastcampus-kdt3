package me.day09.abstracts.definition;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Shape shape = new Shape() {
            @Override
            public void draw() {
                System.out.println("Can't Draw.... 🥲");
            }
        };
    }
    // 객체지향적이지 않은 코드 🤔
    public static double calculateArea(Shape shape) {
        final double PI = 3.14;
        if (shape instanceof Circle) {
            return ((Circle) shape).getRadius() * ((Circle) shape).getRadius() * PI;
        } else if (shape instanceof Rectangle) {
            return ((Rectangle) shape).getWidth() * ((Rectangle) shape).getHeight();
        } else if (shape instanceof Triangle) {
            return ((Triangle) shape).getBase() * ((Triangle) shape).getHeight() * 0.5;
        } else {
            return 0.0;
        }
    }
}
