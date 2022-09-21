package me.day03.conditional;

public class SwitchStringExample {
    public static void main(String[] args) {
        String grade = "B";

        switch(grade) {
            case "A":
            case "a":
                System.out.println("우수 회원");
                break;
            case "B":
            case "b":
                System.out.println("일반 회원");
                break;
            default:
                System.out.println("손님");
        }
    }
}
