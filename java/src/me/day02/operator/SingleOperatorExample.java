package me.day02.operator;

public class SingleOperatorExample {
    public static void main(String[] args) {
        int x = -100;
        int res1 = +x;
        int res2 = -x;
        System.out.println("res1 = " + res1);
        System.out.println("res2 = " + res2);

        short s = 100;
        // short res3 = -s; // 컴파일 에러
        int res3 = -s;
        System.out.println("res3 = " + res3);
    }
}