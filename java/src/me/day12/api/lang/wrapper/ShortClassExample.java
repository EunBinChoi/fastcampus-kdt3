package me.day12.api.lang.wrapper;

import org.openjdk.jol.vm.VM;

public class ShortClassExample {
    public static void main(String[] args) {
        // 기초 자료형은 데이터만 저장하고 관련 함수는 없음
        // 기초 자료형과 관련 메서드를 포함하고 있는 랩퍼 클래스를 만듦
        // 랩퍼 클래스의 메소드는 대부분 static 메소드
        // byte, short, short, long, char, boolean, float, double (기초 자료형)
        // Byte, Short, Short, Long, Character, Boolean, Float, Double (랩퍼 클래스)

        ////////////////////////////////////////////////////////////
        /////////////////// short -> Short (Boxing) ////////////////
        ////////////////////////////////////////////////////////////
        Short short1 = 10;  // 새로운 주소 할당하지 않고 기존에 저장된 10이라는 값을 가지고 옴
        Short short2 = Short.valueOf((short) 10);  // 새로운 주소 할당하지 않고 기존에 저장된 10이라는 값을 가지고 옴
        Short short3 = new Short((short) 10); // 객체 생성자를 통해서 사용하게 되면 새로운 주소 할당
        Short short4 = new Short((short) 10); // 객체 생성자를 통해서 사용하게 되면 새로운 주소 할당
        System.out.println(short1 == short2); // 주소 비교, true
        System.out.println(short3 == short4); // 주소 비교, false
        System.out.println(short1.equals(short2)); // 내용 비교, true
        System.out.println(short3.equals(short4)); // 내용 비교, true
        System.out.println();

        // 사실 숫자 -128 ~ 127까지는 사용빈도가 높기 때문에 이미 메모리에 저장 (주소 공유)
        // 숫자, 문자, 문자열을 byte 단위로 저장하여 JVM 에게 전달
        System.out.println(VM.current().addressOf(10));
        System.out.println(VM.current().addressOf(10));
        System.out.println(VM.current().addressOf(new Short((short) 10)));
        System.out.println(VM.current().addressOf(new Short((short) 10)));
        System.out.println();

        Short short5 = 300;
        Short short6 = Short.valueOf((short) 300);
        Short short7 = new Short((short) 300);
        Short short8 = new Short((short) 300);
        System.out.println(short5 == short6); // 주소 비교, false
        System.out.println(short7 == short8); // 주소 비교, false
        System.out.println(short5.equals(short6)); // 내용 비교, true
        System.out.println(short7.equals(short8)); // 내용 비교, true
        System.out.println();

        // 큰 숫자는 메모리에 할당되어있지 않음 (주소가 다 새롭게 할당)
        System.out.println(VM.current().addressOf(300));
        System.out.println(VM.current().addressOf(300));
        System.out.println(VM.current().addressOf(new Short((short) 300)));
        System.out.println(VM.current().addressOf(new Short((short) 300)));
        System.out.println();

        //////////////////////////////////////////////////////////////
        ///////////////// Short -> short (UnBoxing) //////////////////
        //////////////////////////////////////////////////////////////
        Short shorts = 10;  // boxing (특별한 함수 없이도 가능)
        short shortValue1 = shorts; // unboxing (특별한 함수 없이도 가능)
        short shortValue2 = shorts.shortValue(); // unboxing (shortValue() 함수 호출도 가능)
        System.out.println("Boxing = " + shorts);
        System.out.println("UnBoxing = " + shortValue1);
        System.out.println("UnBoxing = " + shortValue2);
        System.out.println();

        /////////////////////////////////////////////////////////////
        ///////////////// Short 클래스 메소드 ////////////////////////
        ////////////////////////////////////////////////////////////
        System.out.println("Short.TYPE = " + Short.TYPE);
        System.out.println("Short.SIZE = " + Short.SIZE);
        System.out.println("Short.BYTES = " + Short.BYTES);
        System.out.println("Short.MAX_VALUE = " + Short.MAX_VALUE);
        System.out.println("Short.MIN_VALUE = " + Short.MIN_VALUE);
        System.out.println();

        // compare, compareUnsigned
        short s1 = -10;
        short s2 = 10;
        System.out.println("s1와 s2 비교 (signed) = " + Short.compare(s1, s2)); // -1
        System.out.println("s1와 s2 비교 (unsigned) = " + Short.compareUnsigned(s1, s2)); // 1
        System.out.println();

        // String -> short
        String str = "10";
        short parseInt = Short.parseShort(str);
        System.out.println("parseInt = " + parseInt);

        // short -> String
        short s = 10;
        String toStringInt = Short.toString(s);
        System.out.println("toStringInt = " + toStringInt);
        System.out.println();

        // 16진수나 8진수 문자열을 10진수 정수로 바꾸기
        short decodeHex = Short.decode("0x10");
        short decodeOctal = Short.decode("010");
        System.out.println("decodeHex = " + decodeHex);
        System.out.println("decodeOctal = " + decodeOctal);
        System.out.println();

        short reverseBytes = Short.reverseBytes((short) 10);
        System.out.println("reverseBytes = " + reverseBytes);

    }
}
