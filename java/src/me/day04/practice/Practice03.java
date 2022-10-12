package me.day04.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice03 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int STUDENT_NUM = 5;
        double sum = 0;
        double avg = 0;
        double score = 0;

        for (int i = 0; i < STUDENT_NUM; i++) {
            while (true) {
                System.out.printf("[%d] 번 학생 성적 입력 => ", i + 1);
                score = Double.parseDouble(bufferedReader.readLine());
                if (score >= 0 && score <= 100) break;
                System.out.println("입력하신 " + score + "은 유효하지 않은 성적입니다. 다시 입력해주세요.");
            }
            sum += score;
        }
        avg = sum / STUDENT_NUM;
        System.out.println("sum = " + sum + " 점");
        System.out.println("avg = " + avg + " 점");
    }
}
