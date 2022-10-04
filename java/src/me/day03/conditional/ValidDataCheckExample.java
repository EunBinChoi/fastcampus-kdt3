package me.day03.conditional;

import java.util.Scanner;

public class ValidDataCheckExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 나이를 입력받을 경우
        // 나이의 유효범위 0 ~ 100라고 가정
        int age = sc.nextInt();
        if (!(age >= 0 && age <= 100)) {
            System.out.println("Age - Not Valid Data");
        }

        // 구구단 단수를 입력받을 경우
        // 구구단의 유효범위 1 ~ 9라고 가정
        int times = sc.nextInt();
        if (!(times >= 0 && times < 10)) {
            System.out.println("Times - Not Valid Data");
        }

        // 영문자 (대문자와 소문자 존재)를 입력받을 경우
        char alpha = sc.next().toLowerCase().charAt(0);
        if (!((alpha >= 'a' && alpha <= 'z') || (alpha >= 'A' && alpha <= 'Z'))) {
            System.out.println("Alphabet - Not Valid Data");
        }

        alpha = sc.next().toLowerCase().charAt(0);
        if (!(alpha >= 'a' && alpha <= 'z')) {
            System.out.println("Alphabet - Not Valid Data");
        }

        sc.close();
    }
}
