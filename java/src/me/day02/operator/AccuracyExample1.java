package me.day02.operator;

public class AccuracyExample1 {
    public static void main(String[] args) {
        int apple = 1;
        double pieceUnit = 0.1; // 부동소수점 타입은 0.1을 정확하게 표현할 수 없어 근사치로 표현
        int number = 7;

        double res = apple - number * pieceUnit;
        System.out.println(res);
        // 0.29999999999999993
        // 정확히 0.3이 아님
    }
}
