package me.day02.operator;

public class BitReverseOperationExample {
    public static void main(String[] args) {
        int v1 = 10;
        int v2 = ~v1;
        int v3 = ~v1 + 1;
        System.out.printf("binary = %s, decimal = %d\n", toBinaryString(v1), v1);
        System.out.printf("binary = %s, decimal = %d\n", toBinaryString(v2), v2);
        System.out.printf("binary = %s, decimal = %d\n\n", toBinaryString(v3), v3);

        int v4 = -10;
        int v5 = ~v4;
        int v6 = ~v4 + 1;
        System.out.printf("binary = %s, decimal = %d\n", toBinaryString(v4), v4);
        System.out.printf("binary = %s, decimal = %d\n", toBinaryString(v5), v5);
        System.out.printf("binary = %s, decimal = %d\n\n", toBinaryString(v6), v6);
    }

    public static String toBinaryString(int value) {
        String str = Integer.toBinaryString(value);
        while (str.length() < 32) {
            str = "0" + str;
        }
        return str;
    }
}
