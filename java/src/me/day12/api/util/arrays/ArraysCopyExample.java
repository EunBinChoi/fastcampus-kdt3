package me.day12.api.util.arrays;

import java.util.Arrays;

public class ArraysCopyExample {
    public static void main(String[] args) {
        System.out.println();
        System.out.println();
        System.out.println("==================== 일차원 배열 복사 ====================");
        int[] arr1d = {1, 2, 3, 4, 5, 6};
        int[] arr1dCopy = arr1d; // 주소값 대입
        String[] strArr1d = {"Java", "JSP", "Servlet", "Spring"};
        String[] strArr1dCopy = strArr1d; // 주소값 대입
        final int NEW_LEN = 7;

        System.out.println("1-1. Arrays.copyOf()");
        arr1dCopy = Arrays.copyOf(arr1d, NEW_LEN); // 배열 원소값 복사
        strArr1dCopy = Arrays.copyOf(strArr1d, NEW_LEN); // 배열 원소값 복사
        System.out.println("일차원 배열 출력 = " + Arrays.toString(arr1dCopy)); // 일차원 배열 출력
        System.out.println("일차원 배열 출력 = " + Arrays.toString(strArr1dCopy)); // 일차원 배열 출력
        System.out.println("주소 비교 = " + (arr1d == arr1dCopy)); // 주소값 비교 false
        System.out.println("내용 비교 = " + Arrays.equals(arr1d, arr1dCopy)); // 배열 내용 비교 false
        System.out.println("주소 비교 = " + (strArr1d == strArr1dCopy)); // 주소값 비교 false
        System.out.println("내용 비교 = " + Arrays.equals(strArr1d, strArr1dCopy)); // 배열 내용 비교 false
        System.out.println();
        System.out.println();
        /////////////////////////////////////////////////////////////////////////////

        System.out.println("1-2. Arrays.copyOfRange()");
        final int START = 1;
        final int END = 5;
        arr1dCopy = Arrays.copyOfRange(arr1d, START, END); // 배열 원소값 일부 복사 (START <=   < END)
        strArr1dCopy = Arrays.copyOfRange(strArr1d, START, END); // 배열 원소값 일부 복사 (START <=   < END)
        System.out.println("일차원 배열 출력 = " + Arrays.toString(arr1dCopy)); // 일차원 배열 출력
        System.out.println("일차원 배열 출력 = " + Arrays.toString(strArr1dCopy)); // 일차원 배열 출력
        System.out.println("주소 비교 = " + (arr1d == arr1dCopy)); // 주소값 비교 false
        System.out.println("내용 비교 = " + Arrays.equals(arr1d, arr1dCopy)); // 배열 내용 비교 false
        System.out.println("주소 비교 = " + (strArr1d == strArr1dCopy)); // 주소값 비교 false
        System.out.println("내용 비교 = " + Arrays.equals(strArr1d, strArr1dCopy)); // 배열 내용 비교 false
        System.out.println();
        System.out.println();
        /////////////////////////////////////////////////////////////////////////////

        System.out.println("1-3. copy()");
        arr1dCopy = copy(arr1d, NEW_LEN); // 일차원 배열 원소값 복사
        strArr1dCopy = copy(strArr1dCopy, NEW_LEN); // 일차원 배열 원소값 복사
        System.out.println("일차원 배열 출력 = " + Arrays.toString(arr1dCopy)); // 일차원 배열 출력
        System.out.println("일차원 배열 출력 = " + Arrays.toString(strArr1dCopy)); // 일차원 배열 출력
//        Arrays.copyOfRange() // 배열 일부 원소만 복사
        System.out.println("주소 비교 = " + (arr1d == arr1dCopy)); // 주소값 비교 false
        System.out.println("내용 비교 = " + Arrays.equals(arr1d, arr1dCopy)); // 배열 내용 비교 false
        System.out.println("주소 비교 = " + (strArr1d == strArr1dCopy)); // 주소값 비교 false
        System.out.println("내용 비교 = " + Arrays.equals(strArr1d, strArr1dCopy)); // 배열 내용 비교 false
        System.out.println();
        System.out.println();
        /////////////////////////////////////////////////////////////////////////////


        System.out.println("1-4. copyWithStream()");
        arr1dCopy = copyWithStream(arr1d, NEW_LEN); // 일차원 배열 복사
        strArr1dCopy = copyWithStream(strArr1d, NEW_LEN); // 일차원 배열 복사
        System.out.println("일차원 배열 출력 = " + Arrays.toString(arr1dCopy)); // 일차원 배열 출력
        System.out.println("일차원 배열 출력 = " + Arrays.toString(strArr1dCopy)); // 일차원 배열 출력
        System.out.println("주소 비교 = " + (arr1d == arr1dCopy)); // 주소값 비교 false
        System.out.println("내용 비교 = " + Arrays.equals(arr1d, arr1dCopy)); // 배열 내용 비교 false
        System.out.println("주소 비교 = " + (strArr1d == strArr1dCopy)); // 주소값 비교 false
        System.out.println("내용 비교 = " + Arrays.equals(strArr1d, strArr1dCopy)); // 배열 내용 비교 false
        System.out.println();
        System.out.println();
        /////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////


        System.out.println("==================== 이차원 배열 복사 ====================");
        int[][] arr2d = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] arr2dCopy = arr2d; // 주소값 대입
        String[][] strArr2d = {{"a", "ab", "abc"}, {"1", "12", "123"}, {"a1", "b2", "c3"}};
        String[][] strArr2dCopy = strArr2d; // 주소값 대입
        final int NEW_ROW = 3;
        final int NEW_COL = 5;

        System.out.println("2-1. deepCopy()");
        arr2dCopy = deepCopy(arr2d, NEW_ROW, NEW_COL); // 이차원 배열 복사
        strArr2dCopy = deepCopy(strArr2d, NEW_ROW, NEW_COL); // 이차원 배열 복사
        System.out.println("이차원 배열 출력 = " + Arrays.deepToString(arr2dCopy)); // 이차원 배열 출력
        System.out.println("이차원 배열 출력 = " + Arrays.deepToString(strArr2dCopy)); // 이차원 배열 출력
        System.out.println("주소 비교 = " + (arr2d == arr2dCopy)); // 주소값 비교 false
        System.out.println("내용 비교 = " + Arrays.deepEquals(arr2d, arr2dCopy)); // 배열 내용 비교 false
        System.out.println("주소 비교 = " + (strArr2d == strArr2dCopy)); // 주소값 비교 false
        System.out.println("내용 비교 = " + Arrays.deepEquals(strArr2d, strArr2dCopy)); // 배열 내용 비교 false
        System.out.println();
        System.out.println();
        //////////////////////////////////////////////////////////////////////////////

        System.out.println("2-2. deepCopyWithStream()");
        arr2dCopy = deepCopyWithStream(arr2d, NEW_ROW, NEW_COL); // 이차원 배열 복사
        strArr2dCopy = deepCopyWithStream(strArr2d, NEW_ROW, NEW_COL); // 이차원 배열 복사
        System.out.println("이차원 배열 출력 = " + Arrays.deepToString(arr2dCopy)); // 이차원 배열 출력
        System.out.println("이차원 배열 출력 = " + Arrays.deepToString(strArr2dCopy)); // 이차원 배열 출력
        System.out.println("주소 비교 = " + (arr2d == arr2dCopy)); // 주소값 비교 false
        System.out.println("내용 비교 = " + Arrays.deepEquals(arr2d, arr2dCopy)); // 배열 내용 비교 false
        System.out.println("주소 비교 = " + (strArr2d == strArr2dCopy)); // 주소값 비교 false
        System.out.println("내용 비교 = " + Arrays.deepEquals(strArr2d, strArr2dCopy)); // 배열 내용 비교 false
        System.out.println();

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
    public static int[] copyWithStream(int[] original, int newLength) {
        return Arrays.stream(Arrays.copyOf(original, newLength)).toArray();
    }
    public static String[] copyWithStream(String[] original, int newLength) {
        return Arrays.stream(Arrays.copyOf(original, newLength)).toArray(String[]::new);
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
    public static int[][] deepCopyWithStream(int[][] original, int newRow, int newColumn) {
        return Arrays.stream(Arrays.copyOf(original, newRow)).map(r -> Arrays.copyOf(r, newColumn)).toArray(int[][]::new);
    }
    public static String[][] deepCopyWithStream(String[][] original, int newRow, int newColumn) {
        return Arrays.stream(Arrays.copyOf(original, newRow)).map(r -> Arrays.copyOf(r, newColumn)).toArray(String[][]::new);
    }
}
