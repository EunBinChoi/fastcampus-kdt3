package me.day12.api.lang.stringbuilder;

import java.util.Arrays;

public class StringBuilderExample {
    public static void main(String[] args) {
        // StringBuilder implements CharSequence
        StringBuilder stringBuilder1 = new StringBuilder("Java");
        stringBuilder1.append(" is OOP Language");
        stringBuilder1.insert(0, "The ");
        System.out.println(stringBuilder1);

        stringBuilder1.setLength(11);
        System.out.println(stringBuilder1);

        stringBuilder1.replace(4, 4 + "java".length(), "c++");
        System.out.println(stringBuilder1);

        System.out.println("Capacity Before Trim = " + stringBuilder1.capacity());
        stringBuilder1.trimToSize();
        System.out.println("Capacity After Trim = " + stringBuilder1.capacity());

        stringBuilder1.delete(0, 3);
        System.out.println(stringBuilder1);
        System.out.println();


        // 버퍼에 있는 객체들을 String 변환
        // String 상수적인 특징이 있기 때문에 스트링 풀에 들어간 문자열 자체를 수정할 순 없음
        String string = stringBuilder1.toString();
        System.out.println("String = " + string);
        System.out.println();

        ////////////////////////////////////////////////////////////////////
        StringBuilder stringBuilder2 = new StringBuilder(string.strip());
        System.out.println(stringBuilder2.compareTo(stringBuilder1));
        System.out.printf("%d\n", (int)' ');
        System.out.printf("%d\n", (int)'c');

        stringBuilder2.append(" is");
        System.out.println(stringBuilder2);

        System.out.println(stringBuilder2.indexOf("is"));
        System.out.println(stringBuilder2.lastIndexOf("is"));
        System.out.println(stringBuilder2);
        System.out.println();

        CharSequence charSequence = stringBuilder2.subSequence(3, 9);
        System.out.println("SubString = " + charSequence);
        System.out.println();

        char[] chars = new char[100];
        stringBuilder2.getChars(1, 5, chars, 2);
        System.out.println(Arrays.toString(chars));
        for (int i = 0; i < chars.length; i++) {
            System.out.printf("%c = %d\n", chars[i], (int)chars[i]);
        }
        System.out.println();

        StringBuilder stringBuilder3 = stringBuilder2.reverse();
        System.out.println(stringBuilder3);
    }
}
