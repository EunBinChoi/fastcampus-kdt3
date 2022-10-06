package me.day12.api.lang.system;

public class SystemTimeExample {
    public static void main(String[] args) {
        final int SIZE = 1000000000;

        long startMillisTime = System.currentTimeMillis();
        long startNanoTime = System.nanoTime();
        int[] intArr = new int[SIZE];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = i;
        }
        long endMillisTime = System.currentTimeMillis();
        long endNanoTime = System.nanoTime();
        System.out.println("(endMillisTime - startMillisTime)를 통한 시간 계산");
        System.out.println((double) (endMillisTime - startMillisTime) + " ms");
        System.out.println((double) (endMillisTime - startMillisTime) / Math.pow(10, 3) + " sec");
        System.out.println();
        System.out.println("(endNanoTime - startNanoTime)를 통한 시간 계산");
        System.out.println((double) (endNanoTime - startNanoTime) + " ns");
        System.out.println((double) (endNanoTime - startNanoTime) / Math.pow(10, 9) + " sec");

    }
}
