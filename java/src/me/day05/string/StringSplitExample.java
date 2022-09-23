package me.day05.string;

import java.util.Arrays;

public class StringSplitExample {
    public static void main(String[] args) {
        String str1 = "010-1234--5678";
        String[] strSplit1 = str1.split("-");
        System.out.println("strSplit2 = " + Arrays.toString(strSplit1));
        
        String str2 = "010.1234...5678";
        String[] strSplit2 = str2.split("[.]+", 2);
        System.out.println("strSplit1 = " + Arrays.toString(strSplit2));
        
        String str3 = "22/09/23";
        String[] strSplit3 = str3.split("/");
        System.out.println("strSplit3 = " + Arrays.toString(strSplit3));
        String strJoin = String.join("", strSplit3); // 하나의 문자열로 합치기
        System.out.println("strJoin = " + strJoin);

        String str4 = "adkasd100200asd1";
        String[] strSplit4 = str4.split("[a-zA-Z]+");
        System.out.println("strSplit4 = " + Arrays.toString(strSplit4));
    }
}
