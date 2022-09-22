package me.day05.string;

import java.util.ArrayList;
import java.util.List;

public class StringTrimStripDifferenceExample {
    public static void main(String[] args) {
        List<Character> whitespaces = new ArrayList<>();
        for (int c = 0; c < 65536; c++) { // 2바이트 (유니코드 범위)
            if (Character.isWhitespace(c)) {
                char ch = (char)c;
                whitespaces.add(ch);
            }
        }
        System.out.println(trimMethodTest(whitespaces)); // 모두 삭제 불가 (아스키코드만 삭제 가능)
        System.out.println(stripMethodTest(whitespaces)); // 모두 삭제 가능 (유니코드까지 모두 삭제 가능)
    }
    public static boolean trimMethodTest(List<Character> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).toString().trim().length() != 0) {
                return false;
            }
        }
        return true;
    }
    public static boolean stripMethodTest(List<Character> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).toString().strip().length() != 0) {
                return false;
            }
        }
        return true;
    }
}
