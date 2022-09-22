package me.day04.loop;

public class LoopBreakExample {
    public static void main(String[] args) {
        final int TARGET_NUMBER = 6;
        int count = 0;
        while(true) {
            int num = (int)(Math.random()*6) + 1;

            count++;
            if (num == TARGET_NUMBER) {
                System.out.printf("%3d번 실행 - 주사위 %d 번호 도달 성공\n", count, TARGET_NUMBER);
                break;
            } else {
                System.out.printf("%3d번 실행 - 주사위 %d 번호\n", count, num);
            }
        }
        System.out.println("프로그램 종료...");
    }
}
