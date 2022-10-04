package me.day05.string;

import java.util.Scanner;

public class StringMatchesExample {
    static final String USERID_REGEX = "^[a-zA-Z0-9]{8,20}$";
    static final String PASSWORD_REGEX = "^[a-zA-Z0-9~!@#$%^&*()_+,./]{8,20}$";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 아이디와 비밀번호 규칙은 다음과 같음
        // 사용자 아이디: 영문자, 숫자 가능 (길이: 8 ~ 20)
        // 사용자 비밀번호: 영문자, 숫자, 특수문자 가능 (길이: 8 ~ 20)

        System.out.print("아이디를 입력하시오: ");
        String userId = sc.next();
        System.out.print("비밀번호를 입력하시오: ");
        String password = sc.next();

        boolean userIdCheck = userId.matches(USERID_REGEX);
        boolean passwordCheck = password.matches(PASSWORD_REGEX);
        System.out.println(userIdCheck   ? "아이디  사용 가능 :)" : "아이디  사용 불가능 :(");
        System.out.println(passwordCheck ? "비밀번호 사용 가능 :)" : "비밀번호 사용 불가능 :(");

        sc.close();
    }
}
