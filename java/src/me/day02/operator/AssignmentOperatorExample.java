package me.day02.operator;

public class AssignmentOperatorExample {
    public static void main(String[] args) {
        int res = 0;
        res += 10;
        System.out.println(res); // 10

        res -= 5;
        System.out.println(res); // 5

        res *= 3;
        System.out.println(res); // 15

        res /= 5;
        System.out.println(res); // 3

        res %= 3;
        System.out.println(res); // 0
    }
}