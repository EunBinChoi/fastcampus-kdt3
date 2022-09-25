package me.day06.arrays;

import java.util.Arrays;

public class ArraysToStringExample {
    public static void main(String[] args) {
        // 일차원 배열 출력
        int[] arr1d = {1, 2, 3, 4, 5};
        String[] strArr1d = {"Java", "JSP", "Servlet", "Spring"};
        System.out.println(Arrays.toString(arr1d));
        System.out.println(Arrays.toString(strArr1d));
        Arrays.stream(arr1d).forEach((i) -> System.out.print(i + " "));
        Arrays.stream(strArr1d).forEach((i) -> System.out.print(i + " "));
        System.out.println("\n");

        // 이차원 배열 출력
        int[][] arr2d = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        String[][] strArr2d = {{"a", "ab", "abc"}, {"1", "12", "123"}, {"a1", "b2", "c3"}};
        System.out.println(Arrays.deepToString(arr2d));
        System.out.println(Arrays.deepToString(strArr2d));
        Arrays.stream(arr2d).forEach((i) -> {
            Arrays.stream(i).forEach((j) -> System.out.print(j + " "));
            System.out.println();
        });
        Arrays.stream(strArr2d).forEach((i) -> {
            Arrays.stream(i).forEach((j) -> System.out.print(j + " "));
            System.out.println();
        });
    }
}
