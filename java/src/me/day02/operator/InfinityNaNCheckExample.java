package me.day02.operator;

public class InfinityNaNCheckExample {
    public static void main(String[] args) {
        int x = 5;
        double y = 0.0;
        double z = x / y;
        // double z = x % y;

        System.out.println(Double.isInfinite(z)); //  true
        System.out.println(Double.isNaN(z)); // false

        System.out.println(z + 2); // infinity (문제가 되는 코드)

        if (Double.isInfinite(z) || Double.isNaN(z)) {
            System.out.println("값 산출 불가");
        } else {
            System.out.println(z + 2);
        }
    }
}