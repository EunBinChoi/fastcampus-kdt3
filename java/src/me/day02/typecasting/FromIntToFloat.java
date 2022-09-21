package me.day02.typecasting;

public class FromIntToFloat {
    public static void main(String[] args) {
        int num1 = 123456780;
        int num2 = 123456780;

        float num3 = num2;
        num2 = (int) num3;
        System.out.println(num3); // 1.23456784E8
        System.out.println(num2); // 123456784

        int result = num1 - num2;
        System.out.println(result); // -4
    }
}