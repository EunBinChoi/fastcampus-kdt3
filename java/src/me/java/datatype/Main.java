package me.java.datatype;

public class Main {
    public static void main(String[] args) {
        // 자료형 (datatype)
        // --------------------------------
        // 원시형 (primitive type) : 스택 공간
        // int    (4byte == 32bit) : -2^31 ~ 2^31-1
        // float  (4byte == 32bit)
        // double (8byte == 64bit)
        // char   (2byte == 16bit)
        // --------------------------------
        // 참조형 (reference type): 힙 공간
        // String (클래스)

        // 형 변환
        byte b = (byte) 10000; // type casting (명시적 형변환)
        short s = (short) 100000; // type casting (명시적 형변환)
        int i = 10;      // 정수의 기본 단위
        long l = 10;     // promotion (자동 형변환)
        float f = 3.14f;
        double d = 3.14; // 실수의 기본 단위

        // 쓰레기값 예제
        byte var1 = 125; // -128 ~ 127
        int var2 = 125;

        for (int k = 0; k < 5; k ++) {
            var1++; // var1 = var1 + 1
            var2++; // var2 = var2 + 1
            System.out.println("var1: " + var1 + "\t" + "var2: " + var2);
        }
        System.out.println("var2 : " + var2); // var2 : 130 (Promotion)
        // 문자열 + 문자열 = 문자열의 결합 "a" + "b" = "ab"
        // 문자열 + 정수 = 문자열의 결합 "a" + 130 = "a130"
        // "a" + "130" = "a130"
    }
}
