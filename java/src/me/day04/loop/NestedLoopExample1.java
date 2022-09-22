package me.day04.loop;

public class NestedLoopExample1 {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) { // i 생성
            for (int j = 1; j <= 5; j++) { // j 생성
                System.out.println("i = " + i + ", j = " + j);
            } // j 소멸
            System.out.println();
        }
    }
}
