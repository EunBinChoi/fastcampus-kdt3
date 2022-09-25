package me.day01.practice;

public class CommentExample { // 클래스 (이름은 대문자로 작성, Upper Camel Case
    public static void main(String[] args) { // 메인 함수 (프로그램 실행시 자동으로 호출되어 순차적으로 문장이 실행됨)
        /*
         * this is javadoc comment
         * it will be included at .class file (after compile)
         * */

        // 주석 (프로그램 코드에 영향을 주지 않고 코드의 설명이나 협업을 위해 사용)
        // ex) 코드 설명, 개발자 이름, 수정일

        // 단일행 주석
        /* 다중행 주석
         * ㄴㅁㅇㅁㄴㅇ
         * ㅁㄴㅇㅁㄴㅇ
         * ㅁㄴㅇㅁㄴㅇ*/

        // 문장 끝에는 세미콜론 (;) 작성
        System.out.println("Hello Java World - 1"); // 콘솔에 출력하는 함수
        System.out.println("Hello Java World - 2");
        System.out.println("Hello Java World - 3");
        System.out.println("Hello Java World - 4");
        System.out.println("Hello Java World - 5");

        // 콘솔에 출력하는 함수
        System.out.println("1"); // 콘솔에 출력하는 함수 (문장 + 엔터)
        System.out.print("2"); // 콘솔에 출력하는 함수 (문장만 출력)
        System.out.print("3"); // 콘솔에 출력하는 함수 (포맷에 맞춰 출력)
        System.out.println();
    }
}