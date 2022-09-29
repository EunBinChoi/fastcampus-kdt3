package me.day09.polymorphism.instancesof;

import java.util.Objects;

public class Shape {
    protected Point centerPoint;

    public Shape() {
    }

    public Shape(Point centerPoint) {
        this.centerPoint = centerPoint;
    }

    public Point getCenterPoint() {
        return centerPoint;
    }

    public void setCenterPoint(Point centerPoint) {
        this.centerPoint = centerPoint;
    }

    public void draw() {
        System.out.println(Shape.class.getName() + " draw()");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shape shape = (Shape) o;
        return Objects.equals(centerPoint, shape.centerPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(centerPoint);
    }

    @Override
    public String toString() {
        return "Shape{" +
                "centerPoint=" + centerPoint +
                '}';
    }
}
