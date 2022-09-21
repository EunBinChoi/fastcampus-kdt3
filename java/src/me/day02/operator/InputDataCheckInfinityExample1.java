package me.day02.operator;

public class InputDataCheckInfinityExample1 {
    public static void main(String[] args) {
        String userInput = "Infinity";
        double val = Double.valueOf(userInput); // 입력값을 double 타입으로 변환
        double currentBalance = 10000.0;

        currentBalance += val;
        System.out.println(currentBalance); // Infinity
    }
}