package me.day05.string;

public class StringBuilderExample {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("hello");
        sb.append(" world");

        // 수정 완료되면 상수로 바꾸기
        String s = sb.toString();
        System.out.println(s);
    }
}
