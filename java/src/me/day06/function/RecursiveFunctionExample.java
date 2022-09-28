package me.day06.function;

public class RecursiveFunctionExample {

    public static void main(String[] args) {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("sigmaUsingForStatement      = " + sigmaUsingForStatement(50));
            }
        }, "sigmaUsingForStatement");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("sigmaUsingRecursiveFunction = " + sigmaUsingRecursiveFunction(50));
            }
        }, "sigmaUsingRecursiveFunction");

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("factUsingForStatement     = " + factUsingForStatement(12));
            }
        }, "factUsingForStatement");

        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("factUsingRecursiveFunction = " + factUsingRecursiveFunction(12));
            }
        }, "factUsingRecursiveFunction");

        Thread thread5 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("fiboUsingForStatment       = " + fiboUsingForStatment(30));
            }
        }, "fiboUsingForStatment");

        Thread thread6 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("fiboUsingRecursiveFunction = " + fiboUsingRecursiveFunction(30));
            }
        }, "fiboUsingRecursiveFunction");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
    }
    public static long sigmaUsingForStatement(int n) {
        int value = 0;
        for (int i = 1; i <= n; i++) {
            value += i;
        }
        return value;
    }
    public static long sigmaUsingRecursiveFunction(int n) {
        if (n == 1) return 1;
        return n + sigmaUsingRecursiveFunction(n-1);
    }
    public static long factUsingForStatement(int n) {
        int value = 1;
        for (int i = 1; i <= n; i++) {
            value *= i;
        }
        return value;
    }
    public static long factUsingRecursiveFunction(int n) {
        if (n == 1) return 1;
        return n * factUsingRecursiveFunction(n - 1);
    }
    public static long fiboUsingForStatment(int n) {
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
    public static long fiboUsingRecursiveFunction(int n) {
        if (n <= 1) return n;
        return fiboUsingRecursiveFunction(n - 1) + fiboUsingRecursiveFunction(n - 2);
    }
}
