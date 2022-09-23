package me.day05.string;

public class StringConcatExample {
    public static void main(String[] args) {
        String s = "hello";
        // s.charAt(0) = 'H'; // 에러. 일부 원소 수정 불가능

        s += "world"; // 다시 재할당해야 함
        // 다시 재할당하면 상수풀에 "Hello"라는 문자열 객체 생성하고 생성한 객체의 주소값 저장

    }
}