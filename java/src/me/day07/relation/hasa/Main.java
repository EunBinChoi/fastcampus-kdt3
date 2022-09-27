package me.day07.relation.hasa;

public class Main {
    public static void main(String[] args) {
        Point point = new Point(3, 4);
        Circle circle = new Circle(point, 5);

        System.out.println(circle);
    }
}
