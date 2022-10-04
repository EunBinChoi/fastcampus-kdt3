package me.day06.array2d;

import java.util.Scanner;

public class Array2dInitExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int ROW_NUM = 3; // 3명 학생
        final int COL_NUM = 5; // 5개 과목 존재 (국어/수학/사회/과학/영어)
        final String[] subjects = {"국어", "수학", "사회", "과학", "영어"};

        int[][] scores1 = new int[ROW_NUM][COL_NUM];
        double[] avg1 = new double[ROW_NUM];
        for (int i = 0; i < scores1.length; i++) {
            int sum = 0;
            for (int j = 0; j < scores1[i].length; j++) { // scores1[i].length == scores1[0].length
                System.out.printf("%d번 학생의 %s 성적 입력: ", i+1, subjects[j]);
                scores1[i][j] = sc.nextInt();
                sum += scores1[i][j];
            }
            avg1[i] = (double)sum / COL_NUM;
            System.out.printf("%d번 학생의 성적 평균은: %f 입니다\n", i+1, avg1[i]);
            System.out.println();
        }
        System.out.println("============================================\n");

        int[][] scores2 = {{50, 30, 80, 95, 65}, {70, 90, 55, 65, 76}, {96, 90, 80, 87, 75}};
        double[] avg2 = new double[ROW_NUM];
        for (int i = 0; i < scores2.length; i++) {
            int sum = 0;
            for (int j = 0; j < scores2[i].length; j++) { // scores2[i].length == scores2[0].length
                System.out.println("i = " + i + ", j = " + j + " => " + "scores2[i][j] = " + scores2[i][j]);
                sum += scores2[i][j];
            }
            avg2[i] = (double)sum / COL_NUM;
            System.out.printf("%d번 학생의 성적 평균은: %f 입니다\n", i+1, avg2[i]);
            System.out.println();
        }
        System.out.println("============================================\n");

        // 아래 방법으로 배열 초기화는 불가능
//        int[][] scores3;
//        scores3 = {{50, 30, 80, 95, 65}, {70, 90, 55, 65, 76}, {96, 90, 80, 87, 75}};

        int[][] scores4;
        scores4 = new int[][]{{50, 30, 80, 95, 65}, {70, 90, 55, 65, 76}, {96, 90, 80, 87, 75}};
        double[] avg4 = new double[ROW_NUM];
        for (int i = 0; i < scores4.length; i++) {
            int sum = 0;
            for (int j = 0; j < scores4[i].length; j++) { // scores4[i].length == scores4[0].length
                System.out.println("i = " + i + ", j = " + j + " => " + "scores4[i][j] = " + scores4[i][j]);
                sum += scores4[i][j];
            }
            avg4[i] = (double)sum / COL_NUM;
            System.out.printf("%d번 학생의 성적 평균은: %f 입니다\n", i+1, avg4[i]);
            System.out.println();
        }
        System.out.println("============================================\n");

        // 배열은 for-each 구문 사용 가능
        // 인덱스가 내부에 존재하기 때문에 간단한 출력을 위해 사용
        // 만약 인덱스를 사용해야하는 경우라면 다른 for문 이용해야 함
        int[][] scores5 = {{50, 30, 80, 95, 65}, {70, 90, 55, 65, 76}, {96, 90, 80, 87, 75}};
        for (int[] arr: scores5) {
            for (int element : arr) {
                System.out.println("element = " + element);
            }
            System.out.println();
        }

        sc.close();
    }
}
