package me.day07.relation.hasa;

public class Circle {
    private Point centerPoint;
    private int radius;

    public Circle(Point centerPoint) {
        this.centerPoint = centerPoint;
    }

    public Circle(Point centerPoint, int radius) {
        this.centerPoint = centerPoint;
        this.radius = radius;
    }

    public Point getCenterPoint() {
        return centerPoint;
    }

    public void setCenterPoint(Point centerPoint) {
        this.centerPoint = centerPoint;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "centerPoint=" + centerPoint +
                ", radius=" + radius +
                '}';
    }
}
