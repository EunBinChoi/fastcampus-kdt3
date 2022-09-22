package me.day05.string;

public class StringIndexOfExample {
    public static void main(String[] args) {
        String s = "helloh";
        int idx = s.indexOf('h'); // 처음으로 등장하는 'h' 인덱스 반환
        System.out.println(idx);

        idx = s.indexOf('h', 2); // 인덱스 2부터 'h' 찾아 인덱스 반환
        System.out.println(idx);

        idx = s.indexOf("llo"); // 처음으로 등장하는 "llo" 인덱스 반환
        System.out.println(idx);

        idx = s.indexOf("llo", 3); // 인덱스 3부터 "llo"를 찾아 인덱스 반환
        System.out.println(idx); // 문자열 찾지 못하면 -1 반환

    }
}
