package me.day02.operator;

public class AccuracyExample2 {
    public static void main(String[] args) {
        int apple = 1;
        int totalPieces = apple * 10;
        int number = 7;
        int tmp = totalPieces - number;

        double res = tmp / 10.0;
        System.out.println(res); // 0.3
    }
}
