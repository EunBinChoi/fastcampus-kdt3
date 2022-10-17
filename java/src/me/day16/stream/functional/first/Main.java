package me.day16.stream.functional.first;

public class Main {
    public static void main(String[] args) {
        Func func = s -> System.out.println(s); // 함수를 변수로 저장
        func.method("this is functional interface");
    }
}
