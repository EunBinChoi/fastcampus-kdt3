package me.day06.arrays;

import java.util.Arrays;

public class ArraysCopyExample {
    public static void main(String[] args) {
        // 일차원 배열 복사
        int[] arr1d = {1, 2, 3, 4, 5, 6};
        int[] arr1dCopy = arr1d; // 주소값 대입
        String[] strArr1d = {"Java", "JSP", "Servlet", "Spring"};
        String[] strArr1dCopy = strArr1d; // 주소값 대입
        final int NEW_LEN = 7;

        arr1dCopy = Arrays.copyOf(arr1d, NEW_LEN); // 배열 원소값 복사
        strArr1dCopy = Arrays.copyOf(strArr1d, NEW_LEN); // 배열 원소값 복사
        System.out.println(Arrays.toString(arr1dCopy));
        System.out.println(Arrays.toString(strArr1dCopy));

        System.out.println(arr1d == arr1dCopy); // false
        System.out.println(Arrays.equals(arr1d, arr1dCopy)); // false
        System.out.println(strArr1d == strArr1dCopy); // false
        System.out.println(Arrays.equals(strArr1d, strArr1dCopy)); // false

        arr1dCopy = copy(arr1d, NEW_LEN); // 배열 원소값 복사
        strArr1dCopy = copy(strArr1dCopy, NEW_LEN); // 배열 원소값 복사
        System.out.println(Arrays.toString(arr1dCopy));
        System.out.println(Arrays.toString(strArr1dCopy));
//        Arrays.copyOfRange() // 배열 일부 원소만 복사

        System.out.println(arr1d == arr1dCopy); // false
        System.out.println(Arrays.equals(arr1d, arr1dCopy)); // false
        // String.equals()
        // for(int i = 0; i < str.length() ...) ...
        System.out.println(strArr1d == strArr1dCopy); // false
        System.out.println(Arrays.equals(strArr1d, strArr1dCopy)); // false


        // 이차원 배열 복사
        int[][] arr2d = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] arr2dCopy = arr2d; // 주소값 대입
        String[][] strArr2d = {{"a", "ab", "abc"}, {"1", "12", "123"}, {"a1", "b2", "c3"}};
        String[][] strArr2dCopy = strArr2d; // 주소값 대입

        final int NEW_ROW = 3;
        final int NEW_COL = 5;
        arr2dCopy = deepCopy(arr2d, NEW_ROW, NEW_COL);
        strArr2dCopy = deepCopy(strArr2d, NEW_ROW, NEW_COL);
        System.out.println(Arrays.deepToString(arr2dCopy));
        System.out.println(Arrays.deepToString(strArr2dCopy));

        System.out.println(arr2d == arr2dCopy); // false
        System.out.println(Arrays.deepEquals(arr2d, arr2dCopy)); // false
        System.out.println(strArr2d == strArr2dCopy); // false
        System.out.println(Arrays.deepEquals(strArr2d, strArr2dCopy)); // false


        arr2dCopy = deepCopyWithStream(arr2d);
        strArr2dCopy = deepCopyWithStream(strArr2d);
        System.out.println(Arrays.deepToString(arr2dCopy));
        System.out.println(Arrays.deepToString(strArr2dCopy));

        System.out.println(arr2d == arr2dCopy); // false
        System.out.println(Arrays.deepEquals(arr2d, arr2dCopy)); // true
        System.out.println(strArr2d == strArr2dCopy); // false
        System.out.println(Arrays.deepEquals(strArr2d, strArr2dCopy)); // true

    }
    public static int[] copy(int[] original, int newLength) {
        int[] copied = new int[newLength];
        for (int i = 0; i < original.length; i++) {
            copied[i] = original[i];
        }
        return copied;
    }
    public static String[] copy(String[] original, int newLength) {
        String[] copied = new String[newLength];
        for (int i = 0; i < original.length; i++) {
            if (original[i] != null) {
                copied[i] = original[i];
            }
        }
        return copied;
    }
    public static int[][] deepCopy(int[][] original, int newRow, int newColumn) {
        int[][] copied = new int[newRow][newColumn];
        for (int i = 0; i < original.length; i++) {
            for (int j = 0; j < original[i].length; j++) {
                copied[i][j] = original[i][j];
            }
        }
        return copied;
    }
    public static String[][] deepCopy(String[][] original, int newRow, int newColumn) {
        String[][] copied = new String[newRow][newColumn];
        for (int i = 0; i < original.length; i++) {
            for (int j = 0; j < original[i].length; j++) {
                if (original[i][j] != null) {
                    copied[i][j] = original[i][j];
                }
            }
        }
        return copied;
    }
    public static int[][] deepCopyWithStream(int[][] original) {
        return Arrays.stream(original).map(r -> Arrays.copyOf(r, r.length)).toArray(int[][]::new);
    }
    public static String[][] deepCopyWithStream(String[][] original) {
        return Arrays.stream(original).map(r -> Arrays.copyOf(r, r.length)).toArray(String[][]::new);
    }
}