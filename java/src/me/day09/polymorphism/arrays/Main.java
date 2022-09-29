package me.day09.polymorphism.arrays;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = { new Circle(), new Rectangle(), new Triangle() };
        for (int i = 0; i < shapes.length; i++) {
            shapes[i].draw();
        }
    }
}
