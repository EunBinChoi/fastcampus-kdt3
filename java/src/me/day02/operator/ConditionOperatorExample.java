package me.day02.operator;

public class ConditionOperatorExample {
    public static void main(String[] args) {
        int score = 80;
        char grade = (score > 90) ? 'A' : ((score > 80) ? 'B' : 'C');
        System.out.printf("%d점은 %c 등급입니다\n", score, grade);
    }
}
