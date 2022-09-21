package me.day04.loop;

public class ForStatementExample1 {
    public static void main(String[] args) {
        int times = 3;

        for(int i = 1; i < 10; i++) {
            System.out.printf("%d x %d = %d\n", times, i, times*i);
        }
    }
}
