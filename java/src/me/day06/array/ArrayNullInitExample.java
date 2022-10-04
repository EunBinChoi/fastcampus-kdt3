package me.day06.array;

import java.util.Scanner;

public class ArrayNullInitExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] intArr = null;

        for (int i = 0; i < intArr.length; i++) { // NullPointerException
            System.out.printf("%d번 학생 성적 입력: ", i+1);
            intArr[i] = sc.nextInt();
        }
        for (int i = 0; i < intArr.length; i++) {
            System.out.println("i = " + i + ", scores2[i] = " + intArr[i]);
        }

        sc.close();
    }
}
