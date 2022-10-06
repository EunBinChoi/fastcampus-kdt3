package me.day12.api.lang.wrapper;

import org.openjdk.jol.vm.VM;

public class IntegerClassExample {
    public static void main(String[] args) {
        // 기초 자료형은 데이터만 저장하고 관련 함수는 없음
        // 기초 자료형과 관련 메서드를 포함하고 있는 랩퍼 클래스를 만듦
        // 랩퍼 클래스의 메소드는 대부분 static 메소드
        // byte, short, int, long, char, boolean, float, double (기초 자료형)
        // Byte, Short, Integer, Long, Character, Boolean, Float, Double (랩퍼 클래스)

        ////////////////////////////////////////////////////////////
        /////////////////// int -> Integer (Boxing) ////////////////
        ////////////////////////////////////////////////////////////
        Integer integer1 = 10;  // 새로운 주소 할당하지 않고 기존에 저장된 10이라는 값을 가지고 옴
        Integer integer2 = Integer.valueOf(10);  // 새로운 주소 할당하지 않고 기존에 저장된 10이라는 값을 가지고 옴
        Integer integer3 = new Integer(10); // 객체 생성자를 통해서 사용하게 되면 새로운 주소 할당
        Integer integer4 = new Integer(10); // 객체 생성자를 통해서 사용하게 되면 새로운 주소 할당
        System.out.println(integer1 == integer2); // 주소 비교, true
        System.out.println(integer3 == integer4); // 주소 비교, false
        System.out.println(integer1.equals(integer2)); // 내용 비교, true
        System.out.println(integer3.equals(integer4)); // 내용 비교, true
        System.out.println();

        // 사실 숫자 -128 ~ 127까지는 사용빈도가 높기 때문에 이미 메모리에 저장 (주소 공유)
        // 숫자, 문자, 문자열을 byte 단위로 저장하여 JVM 에게 전달
        System.out.println(VM.current().addressOf(10));
        System.out.println(VM.current().addressOf(10));
        System.out.println(VM.current().addressOf(new Integer(10)));
        System.out.println(VM.current().addressOf(new Integer(10)));
        System.out.println();

        Integer integer5 = 300;
        Integer integer6 = Integer.valueOf(300);
        Integer integer7 = new Integer(300);
        Integer integer8 = new Integer(300);
        System.out.println(integer5 == integer6); // 주소 비교, false
        System.out.println(integer7 == integer8); // 주소 비교, false
        System.out.println(integer5.equals(integer6)); // 내용 비교, true
        System.out.println(integer7.equals(integer8)); // 내용 비교, true
        System.out.println();

        // 큰 숫자는 메모리에 할당되어있지 않음 (주소가 다 새롭게 할당)
        System.out.println(VM.current().addressOf(300));
        System.out.println(VM.current().addressOf(300));
        System.out.println(VM.current().addressOf(new Integer(300)));
        System.out.println(VM.current().addressOf(new Integer(300)));
        System.out.println();

        //////////////////////////////////////////////////////////////
        ///////////////// Integer -> int (UnBoxing) //////////////////
        //////////////////////////////////////////////////////////////
        Integer integer = 10;  // boxing (특별한 함수 없이도 가능)
        int intValue = integer; // unboxing (특별한 함수 없이도 가능)
        int intValue2 = integer.intValue(); // unboxing (intValue() 함수 호출도 가능)
        System.out.println("Boxing = " + integer);
        System.out.println("UnBoxing = " + intValue);
        System.out.println("UnBoxing = " + intValue2);
        System.out.println();

        /////////////////////////////////////////////////////////////
        ///////////////// Integer 클래스 메소드 ////////////////////////
        ////////////////////////////////////////////////////////////
        System.out.println("Integer.TYPE = " + Integer.TYPE);
        System.out.println("Integer.SIZE = " + Integer.SIZE);
        System.out.println("Integer.BYTES = " + Integer.BYTES);
        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);
        System.out.println("Integer.MIN_VALUE = " + Integer.MIN_VALUE);
        System.out.println();

        // compare, compareUnsigned
        int s1 = -10;
        int s2 = 10;
        System.out.println("s1와 s2 비교 (signed) = " + Integer.compare(s1, s2)); // -1
        System.out.println("s1와 s2 비교 (unsigned) = " + Integer.compareUnsigned(s1, s2)); // 1
        System.out.println();

        // String -> int
        String str = "10";
        int parseInt = Integer.parseInt(str);
        System.out.println("parseInt = " + parseInt);

        // int -> String
        int s = 10;
        String toStringInt = Integer.toString(s);
        System.out.println("toStringInt = " + toStringInt);
        System.out.println();

        // 16진수나 8진수 문자열을 10진수 정수로 바꾸기
        int decodeHex = Integer.decode("0x10");
        int decodeOctal = Integer.decode("010");
        System.out.println("decodeHex = " + decodeHex);
        System.out.println("decodeOctal = " + decodeOctal);
        System.out.println();

        // 10진수 정수를 2진수나, 16진수, 8진수로 바꾸기
        String binaryString = Integer.toBinaryString(10);
        String hexString = Integer.toHexString(10);
        String octString = Integer.toOctalString(10);
        System.out.println("binaryString = " + binaryString);
        System.out.println("hexString = " + hexString);
        System.out.println("octString = " + octString);
        System.out.println();


    }
}
