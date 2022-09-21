package me.day02.operator;

public class CompareOperatorExample1 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 10;
        boolean res1 = (num1 == num2);
        boolean res2 = (num1 != num2);
        boolean res3 = (num1 <= num2);
        System.out.println(res1); // true
        System.out.println(res2); // false
        System.out.println(res3); // true

        char c1 = 'A';
        char c2 = 'B';
        boolean res4 = (c1 < c2);
        System.out.println(res4); // true
    }
}
