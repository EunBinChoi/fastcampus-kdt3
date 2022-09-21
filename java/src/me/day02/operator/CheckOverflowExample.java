package me.day02.operator;

public class CheckOverflowExample {
    public static void main(String[] args) {
        try {
            int res = safeAdd(2000000000, 2000000000);
            System.out.println(res);
        } catch(ArithmeticException e) {
            System.out.println("overflow 발생하여 정확한 연산 불가");
        }
    }
    public static int safeAdd(int l, int r) {
        if (r > 0) {
            if (l + r > Integer.MAX_VALUE) {
                throw new ArithmeticException("overflow 발생");
            }
        } else {
            if (l + r < Integer.MIN_VALUE) {
                throw new ArithmeticException("overflow 발생");
            }
        }
        return l + r;
    }
}
