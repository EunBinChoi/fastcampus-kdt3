package me.day05.practice;

class Solution06 {
    public String solution(String phone_number) {
        return "*".repeat(phone_number.length()-4) + phone_number.substring(phone_number.length()-4) ;
    }
}

public class Practice06 {
    public static void main(String[] args) {
        String answer1 = new Solution06().solution("01033334444");
        String answer2 = new Solution06().solution("027778888");
        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
    }
}
