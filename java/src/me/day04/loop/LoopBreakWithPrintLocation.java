package me.day04.loop;

// 해당 코드를 실행해보고 왜 실행이 끝났을 때 문장이 하나만 출력이 되었는지 생각해보자
public class LoopBreakWithPrintLocation {
    public static void main(String[] args) {
        while (true) {
            int num = (int)(Math.random() * 10) + 1; // 1 ~ 10
            System.out.println("num = " + num);

            if (num % 3 == 0) break;

            System.out.println("num = " + num);
            System.out.println("==================");
        }
    }
}
