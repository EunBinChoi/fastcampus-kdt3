package me.day09.abstracts.method;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = { new Circle(3), new Rectangle(3, 5), new Triangle(5, 3) };

        for (int i = 0; i < shapes.length; i++) {
            Point point = new Point((int)(Math.random()*10) + 1, (int)(Math.random()*10) + 1);
            shapes[i].setCenterPoint(point);
        }

        for (int i = 0; i < shapes.length; i++) {
            System.out.println(shapes[i].getClass().getName() + " = " + calculateArea(shapes[i]));
        }
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
