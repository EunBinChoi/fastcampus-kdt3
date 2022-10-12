package me.day04.practice;

public class Practice08 {
    public static void main(String[] args) {
        // 각각 한번씩 주석을 달아가며 실행해보세요!
//        example1();
         example2();
    }
    public static void example1() {
        int i = 0;
        while (i < 10) {
            System.out.println(i);
            i++; // i 증가하는 코드 작성
        }
    }
    public static void example2() {
        int k = 1;
        while (k <= 5) {
            int l = 1;
            while (l <= 5) {
                System.out.print("*");
                l++; // l 증가하는 코드 위치 변경
            }
            System.out.println();
            k++;
        }
    }
}
