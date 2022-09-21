package me.day02.operator;

public class OverflowExample {
    public static void main(String[] args) {
        int x = 1000000;
        int y = 1000000;
        int z = x * y; // 10^12 (int가 저장할 수 있는 값의 범위 초과)

        System.out.println(z); // -727379968

        // long 타입은 가능함
        long xl = 1000000;
        long yl = 1000000;
        long zl = xl * yl;

        System.out.println(zl);
    }
}
