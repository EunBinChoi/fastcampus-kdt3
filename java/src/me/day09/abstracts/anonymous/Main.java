package me.day09.abstracts.anonymous;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Shape trapezoid = new Shape() {
            Line[] lines;

            public Line[] getLines() {
                return lines;
            }

            public void setLines(Line[] lines) {
                this.lines = lines;
            }

            @Override
            public void draw() {
                System.out.println("trapezoid draw ...");
            }

            @Override
            public String toString() {
                return "$classname{" +
                        "lines=" + Arrays.toString(lines) +
                        ", centerPoint=" + centerPoint +
                        '}';
            }
        };
        // trapezoid 객체 정의를 위해 만들어놓은 필드와 메소드들이 사라짐
//        Shape otherTrapezoid = new Shape();

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
