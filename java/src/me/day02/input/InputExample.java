package me.day02.input;

import java.util.Scanner; // 사용자 입력받을 수 있는 클래스 Scanner 가져옴 (자바 라이브러리)

public class InputExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 클래스 Scanner 객체 생성

        String name = "";
        int age = 0;
        double height = 0.0;
        System.out.print("이름을 입력하세요: ");
        name = sc.next();
        System.out.print("나이를 입력하세요: ");
        age = sc.nextInt();
        System.out.print("키를 입력하세요: ");
        height = sc.nextDouble();

        System.out.println("이름은 " + name + "나이는 " + age + " 키는 " + height + "입니다");

        sc.close();
    }
}