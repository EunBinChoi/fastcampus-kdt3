package me.day16.stream.functional.transparency;

public class BadCode {
    public void print() {
        System.out.println("hello world.");
    }

    public static void main(String[] args) {
        new BadCode().print(); // 반환값은 없고 그냥 "hello world." 출력
    }
}
