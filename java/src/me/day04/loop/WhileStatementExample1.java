package me.day04.loop;

public class WhileStatementExample1 {
    public static void main(String[] args) {
        int times = 3;

        int i = 1;
        while (i <= 9) {
            System.out.printf("%d x %d = %d\n", times, i, times * i);
            i++;
        }
    }
}
