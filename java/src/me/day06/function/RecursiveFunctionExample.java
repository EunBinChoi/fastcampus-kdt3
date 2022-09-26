package me.day06.function;

import java.lang.management.ManagementFactory;

public class RecursiveFunctionExample {

    public static void main(String[] args) {

        final int N = 10;
        System.out.println(ManagementFactory.getRuntimeMXBean().getName());
        System.out.println("sigmaFor   = " + sigmaFor(N));
        System.out.println("sigmaRecur = " + sigmaRecur(N));
        System.out.println();
        //////////////////////////////////////////////////////////////////////

        System.out.println("factFor   = " + factFor(N));
        System.out.println("factRecur = " + factRecur(N));
        System.out.println();
        /////////////////////////////////////////////////////////////////////

        System.out.println("fiboFor   = " + fiboFor(N));
        System.out.println("fiboRecur = " + fiboRecur(N));
        System.out.println();
    }
    public static long sigmaFor(int n) {
        int value = 0;
        for (int i = 1; i <= n; i++) {
            value += i;
        }
        return value;
    }
    public static long sigmaRecur(int n) {
        if (n == 1) return 1;
        return n + sigmaRecur(n-1);
    }
    public static long factFor(int n) {
        int value = 1;
        for (int i = 1; i <= n; i++) {
            value *= i;
        }
        return value;
    }
    public static long factRecur(int n) {
        if (n == 1) return 1;
        return n * factRecur(n - 1);
    }
    public static long fiboFor(int n) {
        int a = 0;
        int b = 1;
        int c = 0; // 배열 구현도 가능

        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
    public static long fiboRecur(int n) {
        if (n <= 1) return n;
        return fiboRecur(n - 1) + fiboRecur(n - 2);
    }
}
