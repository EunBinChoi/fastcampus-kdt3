package me.day02.datatype;

public class LongExample {
    public static void main(String[] args) {
        long var1 = 10;
        long var2 = 20L;
        // long var3 = 1000000000000; // 컴파일 에러 (int 값이 벗어나는 리터럴에 L을 붙이지 않음)
        long var4 = 1000000000000L;

        System.out.println(var1);
        System.out.println(var2);
        System.out.println(var4);
    }
}
