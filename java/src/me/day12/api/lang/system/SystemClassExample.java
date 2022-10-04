package me.day12.api.lang.system;

public class SystemClassExample {
    public static void main(String[] args) {
        final int SIZE = 1000000000;

        long start = System.currentTimeMillis();
        int[] intArr = new int[SIZE];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = i;
        }
        long end = System.currentTimeMillis();
        System.out.println((double) (end - start) + "ms");
        System.out.println((double) (end - start) / 1000 + "sec");

        System.gc(); // GC 호출

        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("java.version"));
        System.out.println(System.getenv());
    }
}
