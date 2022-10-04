package me.day12.api.lang.stringbuilder;

import java.util.Arrays;

public class StringBufferExample {
    public static void main(String[] args) {
        // StringBuffer implements CharSequence
        StringBuffer stringBuffer1 = new StringBuffer("Java");
        stringBuffer1.append(" is OOP Language");
        stringBuffer1.insert(0, "The ");
        System.out.println(stringBuffer1);

        stringBuffer1.setLength(11);
        System.out.println(stringBuffer1);

        stringBuffer1.replace(4, 4 + "java".length(), "c++");
        System.out.println(stringBuffer1);

        System.out.println("Capacity Before Trim = " + stringBuffer1.capacity());
        stringBuffer1.trimToSize();
        System.out.println("Capacity After Trim = " + stringBuffer1.capacity());

        stringBuffer1.delete(0, 3);
        System.out.println(stringBuffer1);
        System.out.println();


        // 버퍼에 있는 객체들을 String 변환
        // String 상수적인 특징이 있기 때문에 스트링 풀에 들어간 문자열 자체를 수정할 순 없음
        String string = stringBuffer1.toString();
        System.out.println("String = " + string);
        System.out.println();

        ////////////////////////////////////////////////////////////////////
        StringBuffer stringBuffer2 = new StringBuffer(string.strip());
        System.out.println(stringBuffer2.compareTo(stringBuffer1));
        System.out.printf("%d\n", (int)' ');
        System.out.printf("%d\n", (int)'c');

        stringBuffer2.append(" is");
        System.out.println(stringBuffer2);

        System.out.println(stringBuffer2.indexOf("is"));
        System.out.println(stringBuffer2.lastIndexOf("is"));
        System.out.println(stringBuffer2);
        System.out.println();

        CharSequence charSequence = stringBuffer2.subSequence(3, 9);
        System.out.println("SubString = " + charSequence);
        System.out.println();

        char[] chars = new char[100];
        stringBuffer2.getChars(1, 5, chars, 2);
        System.out.println(Arrays.toString(chars));
        for (int i = 0; i < chars.length; i++) {
            System.out.printf("%c = %d\n", chars[i], (int)chars[i]);
        }
        System.out.println();

        StringBuffer stringBuffer3 = stringBuffer2.reverse();
        System.out.println(stringBuffer3);
    }
}
