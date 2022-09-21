package me.day04.loop;

public class NestedLoopExample4 {
    public static void main(String[] args) {
        int i = 1;
        while (i <= 5) {
            int j = 1;
            while (j <= 5) {
                System.out.print("*");
                j++;
            }
            System.out.println();
            i++;
        }
    }
}
