package me.day04.loop;

public class LoopContinueNotGoodCode {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
            if (i % 3 == 0) continue;
        }
    }
}
