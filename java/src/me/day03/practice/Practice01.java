package me.day03.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice01 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        double kor = Double.parseDouble(bufferedReader.readLine());
        if (!(kor >= 0 && kor <= 100)) {
            System.out.println("국어 성적이 유효하지 않습니다.");
            return;
        }

        double math = Double.parseDouble(bufferedReader.readLine());
        if (!(math >= 0 && math <= 100)) {
            System.out.println("수학 성적이 유효하지 않습니다.");
            return;
        }

        double eng = Double.parseDouble(bufferedReader.readLine());
        if (!(eng >= 0 && eng <= 100)) {
            System.out.println("영어 성적이 유효하지 않습니다.");
            return;
        }

        double avg = (kor + math + eng) / 3;
        System.out.println("평점 = " + avg);

        bufferedReader.close();
    }
}
