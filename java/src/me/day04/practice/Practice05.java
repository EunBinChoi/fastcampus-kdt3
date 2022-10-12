package me.day04.practice;

public class Practice05 {
    public static void main(String[] args) {
        int count = 0;
        
        for (int a = 1; a <= 100 ; a++) {
            for (int b = a + 1; b <= 100 ; b++) {
                for (int c = b + 1; c <= 100 ; c++) {
                    if (a * a + b * b == c * c) {
                        System.out.printf("(%3d, %3d, %3d)\n", a, b, c);
                        count++;
                    }
                }
            }
        }
        System.out.println("count = " + count);
    }
}
