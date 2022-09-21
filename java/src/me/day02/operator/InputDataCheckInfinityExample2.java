package me.day02.operator;

public class InputDataCheckInfinityExample2 {
    public static void main(String[] args) {
        String userInput = "Infinity";
        double val = Double.valueOf(userInput); // 입력값을 double 타입으로 변환
        double currentBalance = 10000.0;

        if (Double.isFinite(val)) {
            System.out.println("Infinity이 입력되어 처리할 수 없음");
            val = 0.0;
        }
        currentBalance += val;
        System.out.println(currentBalance); // 10000.0
    }
}