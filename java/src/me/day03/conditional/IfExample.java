package me.day03.conditional;

public class IfExample {
    public static void main(String[] args) {
        int score = 93;

        if (score >= 70) {
            System.out.println("70점 이상이네요!");
            System.out.println("합격");
        }
        if (score < 70) {
            System.out.println("70점 미만이네요!");
            System.out.println("불합격");
        }
        System.out.println("이 문장은 실행될까요?");
    }
}