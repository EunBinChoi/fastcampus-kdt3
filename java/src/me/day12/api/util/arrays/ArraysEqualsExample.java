package me.day12.api.util.arrays;

import java.util.Arrays;

public class ArraysEqualsExample {
    public static void main(String[] args) {
        System.out.println();
        System.out.println();
        System.out.println("==================== 일차원 배열 비교 ====================");
        int[] arr1d = {1, 2, 3, 4, 5, 6};
        int[] arr1dCompare = {1, 2, 3, 4, 5, 6};
        String[] strArr1d = {"Java", "JSP", "Servlet", "Spring"};
        String[] strArr1dCompare = {"Java", "JSP", "Servlet", "Spring"};

        System.out.println("1-1. Arrays.equals()");
        System.out.println("일차원 배열 출력 = " + Arrays.toString(arr1d)); // 일차원 배열 출력
        System.out.println("일차원 배열 출력 = " + Arrays.toString(arr1dCompare)); // 일차원 배열 출력
        System.out.println("주소 비교 = " + (arr1d == arr1dCompare)); // 주소값 비교
        System.out.println("내용 비교 = " + arr1d.equals(arr1dCompare)); // 원소값 비교
        System.out.println("배열 원소값 비교 = " + Arrays.equals(arr1d, arr1dCompare)); // 배열 원소값 비교
        System.out.println();

        System.out.println("일차원 배열 출력 = " + Arrays.toString(strArr1d)); // 일차원 배열 출력
        System.out.println("일차원 배열 출력 = " + Arrays.toString(strArr1dCompare)); // 일차원 배열 출력
        System.out.println("주소 비교 = " + (strArr1d == strArr1dCompare)); // 주소값 비교
        System.out.println("내용 비교 = " + strArr1d.equals(strArr1dCompare)); // 주소값 비교
        System.out.println("배열 원소값 비교 = " + Arrays.equals(strArr1d, strArr1dCompare)); // 배열 원소값 비교
        System.out.println();
        System.out.println();
        /////////////////////////////////////////////////////////////////////////////

        System.out.println("1-2. isEquals()");
        System.out.println("일차원 배열 출력 = " + Arrays.toString(arr1d)); // 일차원 배열 출력
        System.out.println("일차원 배열 출력 = " + Arrays.toString(arr1dCompare)); // 일차원 배열 출력
        System.out.println("주소 비교 = " + (arr1d == arr1dCompare)); // 주소값 비교
        System.out.println("내용 비교 = " + arr1d.equals(arr1dCompare)); // 주소값 비교
        System.out.println("배열 원소값 비교 = " + isEquals(arr1d, arr1dCompare)); // 배열 원소값 비교

        System.out.println("일차원 배열 출력 = " + Arrays.toString(strArr1d)); // 일차원 배열 출력
        System.out.println("일차원 배열 출력 = " + Arrays.toString(strArr1dCompare)); // 일차원 배열 출력
        System.out.println("주소 비교 = " + (strArr1d == strArr1dCompare)); // 주소값 비교
        System.out.println("내용 비교 = " + strArr1d.equals(strArr1dCompare)); // 주소값 비교
        System.out.println("배열 원소값 비교 = " + isEquals(strArr1d, strArr1dCompare)); // 배열 원소값 비교
        System.out.println();
        System.out.println();
        /////////////////////////////////////////////////////////////////////////////


        System.out.println("==================== 이차원 배열 비교 ====================");
        int[][] arr2d = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] arr2dCompare = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        String[][] strArr2d = {{"a", "ab", "abc"}, {"1", "12", "123"}, {"a1", "b2", "c3"}};
        String[][] strArr2dCompare = {{"a", "ab", "abc"}, {"1", "12", "123"}, {"a1", "b2", "c3"}};

        System.out.println("2-1. Arrays.deepEquals()");
        System.out.println("이차원 배열 출력 = " + Arrays.deepToString(arr2d)); // 이차원 배열 출력
        System.out.println("이차원 배열 출력 = " + Arrays.deepToString(arr2dCompare)); // 이차원 배열 출력
        System.out.println("주소 비교 = " + (arr2d == arr2dCompare)); // 주소값 비교
        System.out.println("내용 비교 = " + arr2d.equals(arr2dCompare)); // 주소값 비교
        System.out.println("일차원 배열 원소값 비교 = " + Arrays.equals(arr2d, arr2dCompare)); // 일차원 배열 원소값 비교
        System.out.println("이차원 배열 원소값 비교 = " + Arrays.deepEquals(arr2d, arr2dCompare)); // 이차원 배열 원소값 비교
        System.out.println("이차원 배열 주소값 비교 = " + isEqualsAddress(arr2d, arr2dCompare)); // 이차원 배열 주소값 비교
        System.out.println();

        System.out.println("이차원 배열 출력 = " + Arrays.deepToString(strArr2d)); // 이차원 배열 출력
        System.out.println("이차원 배열 출력 = " + Arrays.deepToString(strArr2dCompare)); // 이차원 배열 출력
        System.out.println("주소 비교 = " + (strArr2d == strArr2dCompare)); // 주소값 비교
        System.out.println("내용 비교 = " + strArr2d.equals(strArr2dCompare)); // 주소값 비교
        System.out.println("일차원 배열 원소값 비교 = " + Arrays.equals(strArr2d, strArr2dCompare)); // 일차원 배열 원소값 비교
        System.out.println("이차원 배열 원소값 비교 = " + Arrays.deepEquals(strArr2d, strArr2dCompare)); // 이차원 배열 원소값 비교
        System.out.println("이차원 배열 주소값 비교 = " + isEqualsAddress(strArr2d, strArr2dCompare)); // 이차원 배열 주소값 비교
        System.out.println();
        System.out.println();
        ////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("2-2. isDeepEquals()");
        System.out.println("이차원 배열 출력 = " + Arrays.deepToString(arr2d)); // 이차원 배열 출력
        System.out.println("이차원 배열 출력 = " + Arrays.deepToString(arr2dCompare)); // 이차원 배열 출력
        System.out.println("주소 비교 = " + (arr2d == arr2dCompare)); // 주소값 비교
        System.out.println("내용 비교 = " + arr2d.equals(arr2dCompare)); // 주소값 비교
        System.out.println("일차원 배열 원소값 비교 = " + Arrays.equals(arr2d, arr2dCompare)); // 일차원 배열 원소값 비교
        System.out.println("이차원 배열 원소값 비교 = " + isDeepEquals(arr2d, arr2dCompare)); // 이차원 배열 원소값 비교
        System.out.println("이차원 배열 주소값 비교 = " + isEqualsAddress(arr2d, arr2dCompare)); // 이차원 배열 주소값 비교
        System.out.println();

        System.out.println("이차원 배열 출력 = " + Arrays.deepToString(strArr2d)); // 이차원 배열 출력
        System.out.println("이차원 배열 출력 = " + Arrays.deepToString(strArr2dCompare)); // 이차원 배열 출력
        System.out.println("주소 비교 = " + (strArr2d == strArr2dCompare)); // 주소값 비교
        System.out.println("내용 비교 = " + strArr2d.equals(strArr2dCompare)); // 주소값 비교
        System.out.println("일차원 배열 원소값 비교 = " + Arrays.equals(strArr2d, strArr2dCompare)); // 일차원 배열 원소값 비교
        System.out.println("이차원 배열 원소값 비교 = " + isDeepEquals(strArr2d, strArr2dCompare)); // 이차원 배열 원소값 비교
        System.out.println("이차원 배열 주소값 비교 = " + isEqualsAddress(strArr2d, strArr2dCompare)); // 이차원 배열 주소값 비교
        System.out.println();
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

    public static boolean isEqualsAddress(int[][] original, int[][] object) {
        int minLength = Math.min(original.length, object.length);
        for (int i = 0; i < minLength; i++) {
            if (original[i] != object[i]) return false;
        }
        return true;
    }

    public static boolean isEqualsAddress(String[][] original, String[][] object) {
        int minLength = Math.min(original.length, object.length);
        for (int i = 0; i < minLength; i++) {
            if (original[i] != object[i]) return false;
        }
        return true;
    }
}
