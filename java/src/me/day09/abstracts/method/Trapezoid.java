package me.day09.abstracts.method;

import java.util.Arrays;

public class Trapezoid extends Shape {
    private Line[] lines; // 윗변, 아랫변, 왼쪽변, 오른쪽변 들어온다고 가정

    public Trapezoid() {
    }

    public Trapezoid(Point centerPoint) {
        super(centerPoint);
    }

    public Trapezoid(Line[] lines) {
        this.lines = lines;
    }

    public Trapezoid(Point centerPoint, Line[] lines) {
        super(centerPoint);
        this.lines = lines;
    }

    public Line[] getLines() {
        return lines;
    }

    public void setLines(Line[] lines) {
        this.lines = lines;
    }

    // draw() 함수 무조건 재정의!
    @Override
    public void draw() {
        System.out.println(Trapezoid.class.getName() + " draw()");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Trapezoid trapezoid = (Trapezoid) o;
        return Arrays.equals(lines, trapezoid.lines);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(lines);
        return result;
    }

    @Override
    public String toString() {
        return "Trapezoid{" +
                "lines=" + Arrays.toString(lines) +
                ", centerPoint=" + centerPoint +
                '}';
    }
}

