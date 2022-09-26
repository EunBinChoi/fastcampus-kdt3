package me.day06.array2d;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Array2dMajorExample {
    public static void main(String[] args) {
        final int ROW_NUM = 3;
        final int COL_NUM = 5;
        int[][] arr2d = new int[ROW_NUM][COL_NUM];
        for (int i = 0; i < arr2d.length; i++) {
            for (int j = 0; j < arr2d[i].length; j++) {
                arr2d[i][j] = (i + 1) * (j + 1);
            }
        }

        int[][] rowMajor = InitializeRowMajor(arr2d);
        int[][] colMajor = InitializeColumnMajor(arr2d);
        System.out.println(Arrays.deepToString(rowMajor));
        System.out.println(Arrays.deepToString(colMajor));
        System.out.println(Arrays.deepToString(transposeMatrix(rowMajor)));

    }
    public static int[][] InitializeRowMajor(int[][] original) {
        int[][] rowMajor = new int[original.length][original[0].length];
        for (int i = 0; i < rowMajor.length; i++) {
            for (int j = 0; j < rowMajor[i].length; j++) {
                rowMajor[i][j] = original[i][j];
            }
        }
        return rowMajor;
    }
    public static int[][] InitializeColumnMajor(int[][] original) {
        int[][] colMajor = new int[original[0].length][original.length];
        for (int i = 0; i < colMajor.length; i++) {
            for (int j = 0; j < colMajor[i].length; j++) {
                colMajor[i][j] = original[j][i];
            }
        }
        return colMajor;
    }
    public static int[][] transposeMatrix(int[][] original) {
        return IntStream.range(0, original[0].length)
                    .mapToObj(i -> Stream.of(original).mapToInt(row -> row[i]).toArray())
                    .toArray(int[][]::new);
    }
}
