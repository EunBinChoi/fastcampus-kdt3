package me.day06.arrays;

import java.util.Arrays;

public class ArraysEqualsExample {
    public static void main(String[] args) {
        // 일차원 배열 비교
        int[] arr1d = {1, 2, 3, 4, 5, 6};
        int[] arr1dCompare = {1, 2, 3, 4, 5, 6, 7};
        String[] strArr1d = {"Java", "JSP", "Servlet", "Spring"};
        String[] strArr1dCompare = {"Java", "JSP", "Servlet", "Spring"};

        System.out.println(arr1d == arr1dCompare); // 주소값 비교
        System.out.println(arr1d.equals(arr1dCompare)); // 주소값 비교
        System.out.println(strArr1d == strArr1dCompare); // 주소값 비교
        System.out.println(strArr1d.equals(strArr1dCompare)); // 주소값 비교

        System.out.println(isEquals(arr1d, arr1dCompare)); // 원소값 비교
        System.out.println(isEquals(strArr1d, strArr1dCompare)); // 원소값 비교
        System.out.println(Arrays.equals(arr1d, arr1dCompare)); // 원소값 비교
        System.out.println(Arrays.equals(strArr1d, strArr1dCompare)); // 원소값 비교
        System.out.println();

        // 이차원 배열 비교
        int[][] arr2d = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] arr2dCompare = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        String[][] strArr2d = {{"a", "ab", "abc"}, {"1", "12", "123"}, {"a1", "b2", "c3"}};
        String[][] strArr2dCompare = {{"a", "ab", "abc"}, {"1", "12", "123"}, {"a1", "b2", "c3"}};

        System.out.println(arr2d == arr2dCompare); // 주소값 비교
        System.out.println(strArr2d == strArr2dCompare); // 주소값 비교
        System.out.println(arr2d.equals(arr2dCompare)); // 주소값 비교
        System.out.println(strArr2d == strArr2dCompare); // 주소값 비교

        for (int i = 0; i < arr2d.length; i++) {
            System.out.println(arr2d[i] == arr2dCompare[i]); // 주소값 비교
            System.out.println(strArr2d[i] == strArr2dCompare[i]); // 주소값 비교
            System.out.println(arr2d[i].equals(arr2dCompare[i])); // 주소값 비교
            System.out.println(strArr2d[i] != null && strArr2d[i].equals(strArr2dCompare[i])); // 주소값 비교
        }
        System.out.println(isDeepEquals(arr2d, arr2dCompare)); // 원소값 비교
        System.out.println(isDeepEquals(strArr2d, strArr2dCompare)); // 원소값 비교
        System.out.println(Arrays.deepEquals(arr2d, arr2dCompare)); // 원소값 비교
        System.out.println(Arrays.deepEquals(strArr2d, strArr2dCompare)); // 원소값 비교
        System.out.println();
    }
    public static boolean isEquals(int[] a, int[] b) {
        if (a.length != b.length) return false;

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
    public static boolean isEquals(String[] a, String[] b) {
        if (a.length != b.length) return false;

        for (int i = 0; i < a.length; i++) {
            if (a[i] != null && !a[i].equals(b[i])) return false;
        }
        return true;
    }
    public static boolean isDeepEquals(int[][] a, int[][] b) {
        if (a.length != b.length) return false;
        if (a[0].length != b[0].length) return false;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] != b[i][j]) return false;
            }
        }
        return true;
    }
    public static boolean isDeepEquals(String[][] a, String[][] b) {
        if (a.length != b.length) return false;
        if (a[0].length != b[0].length) return false;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] != null && !a[i][j].equals(b[i][j])) return false;
            }
        }
        return true;
    }
}
