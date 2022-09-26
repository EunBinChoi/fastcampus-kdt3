package me.day06.array2d;

public class Array1dtoArray2dExample {
    public static void main(String[] args) {
        final int ROW_NUM = 3;
        final int COL_NUM = 5;
        final int NUM = ROW_NUM * COL_NUM;
        int[] arr1d = new int[NUM];
        for (int i = 0; i < arr1d.length; i++) {
            arr1d[i] = i + 1;
        }
        for (int element: arr1d) {
            System.out.printf("%2d ", element);
        }
        System.out.println("\n");

        int[][] arr2d = new int[ROW_NUM][COL_NUM];
        for (int i = 0; i < arr2d.length; i++) {
            for (int j = 0; j < arr2d[i].length; j++) {
                arr2d[i][j] = arr1d[i * COL_NUM + j];
            }
        }
        for (int i = 0; i < arr2d.length; i++) {
            for (int j = 0; j < arr2d[i].length; j++) {
                System.out.printf("%2d ", arr2d[i][j]);
            }
            System.out.println();
        }
        System.out.println("\n");

        int[] arr1dRevert = new int[ROW_NUM * COL_NUM];
        for (int i = 0; i < arr2d.length; i++) {
            for (int j = 0; j < arr2d[i].length; j++) {
                arr1dRevert[i * COL_NUM + j] = arr2d[i][j];
            }
        }
        for (int element: arr1dRevert) {
            System.out.printf("%2d ", element);
        }
    }
}
