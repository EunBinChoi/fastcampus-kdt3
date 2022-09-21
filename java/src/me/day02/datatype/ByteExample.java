package me.day02.datatype;

public class ByteExample {
    public static void main(String[] args) {
        byte var1 = -128;
        byte var2 = -30;
        byte var3 = 0;
        byte var4 = 30;
        byte var5 = 127;
        byte var6 = (byte)128;

        System.out.println(var1);
        System.out.println(var2);
        System.out.println(var3);
        System.out.println(var4);
        System.out.println(var5);
        System.out.println(var6); // -128로 출력 (byte 범위에서 순환)
        // 쓰레기값: 저장할 수 있는 값의 범위를 초과해서 값이 저장되는 경우
        // 개발자는 쓰레기값이 생기지 않도록 주의해야 함
    }
}