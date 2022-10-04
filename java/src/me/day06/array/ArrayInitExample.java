package me.day06.array;

import java.util.Scanner;

public class ArrayInitExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int NUM = 5;
        int[] scores1 = new int[NUM];
        for (int i = 0; i < scores1.length; i++) {
            System.out.printf("%d 학생 성적 입력: ", i+1);
            scores1[i] = sc.nextInt();
        }
        for (int i = 0; i < scores1.length; i++) {
            System.out.println("i = " + i + ", scores1[i] = " + scores1[i]);
        }
        System.out.println("============================================");

        int[] scores2 = {90, 80, 77, 100, 65};
        for (int i = 0; i < scores2.length; i++) {
            System.out.println("i = " + i + ", scores2[i] = " + scores2[i]);
        }
        System.out.println("============================================");

        // 아래 방법으로 배열 초기화는 불가능
//        int[] scores3;
//        scores3 = {90, 80, 77, 100, 65};

        int[] scores4;
        scores4 = new int[]{90, 80, 77, 100, 65};
        for (int i = 0; i < scores4.length; i++) {
            System.out.println("i = " + i + ", scores4[i] = " + scores4[i]);
        }
        System.out.println("============================================");

        // 배열은 for-each 구문 사용 가능
        // 인덱스가 내부에 존재하기 때문에 간단한 출력을 위해 사용
        // 만약 인덱스를 사용해야하는 경우라면 다른 for문 이용해야 함
        int[] scores5 = {90, 80, 77, 100, 65};
        for (int score : scores5) {
            System.out.println("score = " + score);
        }

        sc.close();
    }
}
