package me.day05.string;

import java.util.Arrays;

public class StringToCharArrayExample {
    public static void main(String[] args) {
        // String 수정 불가 (String Pool에 저장)
        String str = "this is constant string. Immutable";
        // str.charAt(0) = 'T'; // 불가능

        char[] charArr = str.toCharArray();
        System.out.println(Arrays.toString(charArr));

        // char[]은 수정 가능 (힙에 저장)
        // StringBuilder, StringBuffer도 char[]로 구현되어있음
        charArr[0] = 'T'; // 가능
        System.out.println(Arrays.toString(charArr));
        String res = String.valueOf(charArr); // 수정완료. 다시 상수화하기
        System.out.println(res);
    }
}
