package me.day02.operator;

public class BitShiftExample {
    public static void main(String[] args) {
        System.out.println("1 << 3 = " + (1 << 3)); // 8
        System.out.println("-8 >> 3 = " + (-8 >> 3)); // -1
        System.out.println("-8 >>> 3 = " + (-8 >>> 3)); // 536870911
    }
}