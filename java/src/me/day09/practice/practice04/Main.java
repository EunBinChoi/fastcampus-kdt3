package me.day09.practice.practice04;

import me.day09.practice.practice04.Member;

public class Main {
    public static void main(String[] args) {
        Member kalen = new Member("aaa", "a1111",
    "010-1234-5678", "q123@naver.com", "901010");
        String[] candidates = {"010-1234-5699", "010-1234-6789", "010-2345-5678", "010-1345-5768"};

        String finalPhoneNumber = kalen.getNewPhoneNumber(candidates);
        System.out.println("finalPhoneNumber = " + finalPhoneNumber);

    }
}
