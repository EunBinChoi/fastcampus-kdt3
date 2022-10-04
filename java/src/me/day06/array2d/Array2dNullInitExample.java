package me.day06.array2d;

import java.util.Scanner;

public class Array2dNullInitExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr2d = null;

        for (int i = 0; i < arr2d.length; i++) { // NullPointerException
            for (int j = 0; j < arr2d[i].length; j++) {
                System.out.print("i = " + i + ", j = " + j + "데이터 입력: ");
                arr2d[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < arr2d.length; i++) { // NullPointerException
            for (int j = 0; j < arr2d[i].length; j++) {
                System.out.print("arr2d[i][j] = " + arr2d);
            }
            System.out.println();
        }
        sc.close();
    }
}
