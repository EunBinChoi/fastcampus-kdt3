package me.day02.typecasting;

public class CheckValueBeforeCasting {
    public static void main(String[] args) {
        int i = 128; // -128 ~ 127

        // i에 저장된 값이 byte 범위니 (-128 ~ 127 사이에 있니)
        if ((i < Byte.MIN_VALUE) || (i > Byte.MAX_VALUE)) {
            System.out.println("byte 타입으로 변환할 수 없음");
            System.out.println("값 다시 확인 바람");
        } else {
            byte b = (byte) i;
            System.out.println(b);
        }
    }
}