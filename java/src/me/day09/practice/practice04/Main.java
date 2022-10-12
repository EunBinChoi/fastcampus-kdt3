package me.day09.practice.practice04;

import me.day09.practice.practice04.Member;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Member kalen = new Member("aaa", "a1111",
    "010-1234-5678", "q123@naver.com", "901010");

        final int CANDIDATES = 10;
        String[] candidates = new String[CANDIDATES];

        for (int i = 0; i < CANDIDATES; i++) {
            candidates[i] = randomPhoneNumber();
        }
        System.out.println("Arrays.toString(candidates) = " + Arrays.toString(candidates));

        String finalPhoneNumber = kalen.getNewPhoneNumber(candidates);
        System.out.println("finalPhoneNumber = " + finalPhoneNumber);

    }

    private static String randomPhoneNumber() {
        String random = "010";

        for(int i = 0; i < 2; i++) {
            random += "-";
            for(int j = 0; j < 4; j++) {
                int digit = (int)(Math.random() * 10); // 0 ~ 9
                random += digit;
            }
        }
        return random;
    }
}
