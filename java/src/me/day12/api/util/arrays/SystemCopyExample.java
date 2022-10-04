package me.day12.api.util.arrays;

import java.util.Arrays;

public class SystemCopyExample {
    public static void main(String[] args) {
        // System.arraycopy(원본 배열, 원본 배열 시작 인덱스, 복사 배열, 복사 배열 시작 인덱스, 복사 개수)
        int[] arr = {1, 2, 3, 4, 5, 6};
        int[] arrCopy = new int[arr.length];
        final int NEW_LEN = 3;

        System.arraycopy(arr, 1, arrCopy, 0, NEW_LEN);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arrCopy));
        System.out.println();

        String[] strArr = {"Java", "JSP", "Servlet", "Spring"};
        String[] strArrCopy = new String[strArr.length];
        System.arraycopy(strArr, 1, strArrCopy, 0, NEW_LEN);
        System.out.println(Arrays.toString(strArr));
        System.out.println(Arrays.toString(strArrCopy));
        System.out.println();
    }
}
