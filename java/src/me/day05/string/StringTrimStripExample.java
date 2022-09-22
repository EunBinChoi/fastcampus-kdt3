package me.day05.string;

public class StringTrimStripExample {
    public static void main(String[] args) {
        // 양변에 있는 공백문자 삭제
        // 아스키코드에 대해서는 모두 다 작동 잘함
        String str1 = "        \t\t\n\rhello        \t\t\n\r";
        System.out.println("Before: \"" + str1 + "\"");
        System.out.println("After trim: \"" + str1.trim() + "\"");
        System.out.println("After strip: \"" + str1.strip() + "\"");
        System.out.println();

        // 유니코드에 대해서는 trim() 작동하지 않음
        // 유니코드에 대해서는 strip()만 작동 (JDK11+)
        String str2 = '\u2001' + "String    with    space" + '\u2001';
        System.out.println("Before: \"" + str2 + "\"");
        System.out.println("After trim: \"" + str2.trim() + "\"");
        System.out.println("After strip: \"" + str2.strip() + "\"");
    }
}
