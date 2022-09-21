package me.day03.conditional;

public class IfNestedExample {
    public static void main(String[] args) {
        int score = 91;
        String grade = "";

        if (score >= 90) {
            if (score >= 95) {
                grade = "A+";
            } else {
                grade = "A-";
            }
        } else {
            if (score >= 80) {
                if (score >= 85) {
                    grade = "B+";
                } else {
                    grade = "B-";
                }
            }
        }

        System.out.printf("당신의 학점은 %s 입니다 \n", grade);
    }
}