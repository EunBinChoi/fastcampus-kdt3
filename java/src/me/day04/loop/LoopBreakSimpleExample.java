package me.day04.loop;

public class LoopBreakSimpleExample {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " - ");
            if (i % 3 == 0) {
                System.out.println("3의 배수");
                System.out.println("반복문 종료");
                break;
            } else {
                System.out.println("3의 배수 아님");
            }
        }
    }
}
