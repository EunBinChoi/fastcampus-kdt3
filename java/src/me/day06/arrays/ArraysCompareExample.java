package me.day06.arrays;

import java.util.Arrays;

public class ArraysCompareExample {
    public static void main(String[] args) {
        int[] arr1d = {1, 2, 3, 4, 5, 6};
        int[] arr1dCompare = {1, 2, 3, 4, 5, 6, 7};
        String[] strArr1d = {"Java", "JSP", "Servlet", "Spring"};
        String[] strArr1dCompare = {"Javp", "JSP", "Servlet", "Spring", "Python"};

        System.out.println(compare(arr1d, arr1dCompare)); // 원소값 비교
        System.out.println(Arrays.compare(arr1d, arr1dCompare)); // 원소값 비교
        System.out.println(compare(strArr1d, strArr1dCompare)); // 원소값 비교
        System.out.println(Arrays.compare(strArr1d, strArr1dCompare)); // 원소값 비교
        System.out.println();
    }
    public static int compare(int[] a, int[] b) {
        int minLength = Math.min(a.length, b.length);
        for (int i = 0; i < minLength; i++) {
            if (a[i] != b[i]) {
                return Integer.compare(a[i], b[i]);
            }
        }
        if (a.length < b.length) return -1;
        else if (a.length > b.length) return 1;
        else return 0;
    }
    public static int compare(String[] a, String[] b) {
        int minLength = Math.min(a.length, b.length);
        for (int i = 0; i < minLength; i++) {
            if (a[i] != null && !a[i].equals(b[i])) {
                return a[i].compareTo(b[i]);
            }
        }
        if (a.length < b.length) return -1;
        else if (a.length > b.length) return 1;
        else return 0;
    }
}
