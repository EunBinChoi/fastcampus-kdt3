package me.day06.practice;

import java.util.Arrays;

public class Practice03 {
    public static void main(String[] args) {

        final int STUDENT_NUM = 5;
        final int SUBJECT_NUM = 3;

        int[][] scores2d = {
                {50, 60, 70},
                {60, 76, 100},
                {95, 88, 87},
                {60, 65, 85},
                {100, 85, 77}
        };

        String[] subjectsName = { "국어", "수학", "영어" };
        int[] subjects = new int[SUBJECT_NUM];
        for (int i = 0; i < subjects.length; i++) {
            subjects[i] = i;
        }

        int[] students = new int[STUDENT_NUM];
        for (int i = 0; i < students.length; i++) {
            students[i] = i;
        }
        double[] subjectsAverage = calculateSubjectsAverage(scores2d);
        double[] studentsAverage = calculateStudentsAverage(scores2d);
        System.out.println("subject's average => " + Arrays.toString(subjectsAverage));
        System.out.println("student's average => " + Arrays.toString(studentsAverage));
        System.out.println();

        sort(subjectsAverage, subjects, "descending");
        System.out.println("[ subject's average by descending order ]");
        System.out.println("\n-----------------------------------------");
        for (int i = 0; i < subjects.length; i++) {
            System.out.printf("%10s | ", subjectsName[subjects[i]]);
        }
        System.out.println("\n-----------------------------------------");
        for (int i = 0; i < subjectsAverage.length; i++) {
            System.out.printf("%10s  | ", subjectsAverage[i]);
        }
        System.out.println("\n-----------------------------------------");

        System.out.println();
        sort(studentsAverage, students, "ascending");
        System.out.println("[ student's average by ascending order ]");
        System.out.println("\n--------------------------------------------------------------------------");
        for (int i = 0; i < students.length; i++) {
            System.out.printf("%10s  | ", students[i] + 1 + "번 학생");
        }
        System.out.println("\n--------------------------------------------------------------------------");
        for (int i = 0; i < studentsAverage.length; i++) {
            System.out.printf("%12f | ", studentsAverage[i]);
        }
        System.out.println("\n--------------------------------------------------------------------------");
    }

    public static double[] calculateSubjectsAverage(int[][] scores2d) {
        double[] subjectAverage = new double[scores2d[0].length]; // 각 과목별 학생 성적 평균

        for (int i = 0; i < scores2d[0].length; i++) { // COLUMN
            int sum = 0;
            for (int j = 0; j < scores2d.length; j++) { // ROW
                sum += scores2d[j][i];
            }
            subjectAverage[i] = (double) sum / scores2d.length;
        }
        return subjectAverage;
    }

    public static double[] calculateStudentsAverage(int[][] scores2d) {
        double[] studentsAverage = new double[scores2d.length]; // 각 학생별 과목 성적 평균

        for (int i = 0; i < scores2d.length; i++) { // ROW
            int sum = 0;
            for (int j = 0; j < scores2d[i].length; j++) { // COLUMN
                sum += scores2d[i][j];
            }
            studentsAverage[i] = (double) sum / scores2d[0].length;
        }
        return studentsAverage;
    }

    public static int compare(String order) {
        return (order.equals("ascending")) ? 1 : -1;
    }

    public static void sort(double[] array, int[] index, String order) {
        int comp = compare(order);
        // ascending : 1, descending: -1
        // ascending : array[j] > array[j + 1] -> swap
        //             array[j] - array[j + 1] > 0

        // descending: array[j] < array[j + 1] -> swap
        //             array[j] - array[j + 1] < 0

        // (array[j] - array[j + 1]) * comp > 0
        // -(array[j] - array[j + 1]) > 0
        // -array[j] + array[j + 1] > 0
        // 0 > array[j] - array[j + 1]


        for (int i = array.length - 1; i > 0; i--) { // n 숫자 정렬시 반복해야하는 횟수 -> n - 1
            for (int j = 0; j < i; j++) {
                if ((array[j] - array[j + 1]) * comp > 0) {
                    double value = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = value;

                    int idx = index[j];
                    index[j] = index[j + 1];
                    index[j + 1] = idx;
                }
            }
        }
    }
}
