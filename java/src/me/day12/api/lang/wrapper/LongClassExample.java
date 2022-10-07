package me.day12.api.lang.wrapper;

import org.openjdk.jol.vm.VM;

public class LongClassExample {
    public static void main(String[] args) {
        // 기초 자료형은 데이터만 저장하고 관련 함수는 없음
        // 기초 자료형과 관련 메서드를 포함하고 있는 랩퍼 클래스를 만듦
        // 랩퍼 클래스의 메소드는 대부분 static 메소드
        // byte, short, int, long, char, boolean, float, double (기초 자료형)
        // Byte, Short, Long, Long, Character, Boolean, Float, Double (랩퍼 클래스)

        ////////////////////////////////////////////////////////////
        /////////////////// long -> Long (Boxing) //////////////////
        ////////////////////////////////////////////////////////////
        Long long1 = 10L;  // 새로운 주소 할당하지 않고 기존에 저장된 10이라는 값을 가지고 옴
        Long long2 = Long.valueOf(10);  // 새로운 주소 할당하지 않고 기존에 저장된 10이라는 값을 가지고 옴
        Long long3 = new Long(10); // 객체 생성자를 통해서 사용하게 되면 새로운 주소 할당
        Long long4 = new Long(10); // 객체 생성자를 통해서 사용하게 되면 새로운 주소 할당
        System.out.println(long1 == long2); // 주소 비교, true
        System.out.println(long3 == long4); // 주소 비교, false
        System.out.println(long1.equals(long2)); // 내용 비교, true
        System.out.println(long3.equals(long4)); // 내용 비교, true
        System.out.println();

        // 사실 숫자 -128 ~ 127까지는 사용빈도가 높기 때문에 이미 메모리에 저장 (주소 공유)
        // 숫자, 문자, 문자열을 byte 단위로 저장하여 JVM 에게 전달
        System.out.println(VM.current().addressOf(10L));
        System.out.println(VM.current().addressOf(10L));
        System.out.println(VM.current().addressOf(new Long(10L)));
        System.out.println(VM.current().addressOf(new Long(10L)));
        System.out.println();

        Long long5 = 300L;
        Long long6 = Long.valueOf(300L);
        Long long7 = new Long(300L);
        Long long8 = new Long(300L);
        System.out.println(long5 == long6); // 주소 비교, false
        System.out.println(long7 == long8); // 주소 비교, false
        System.out.println(long5.equals(long6)); // 내용 비교, true
        System.out.println(long7.equals(long8)); // 내용 비교, true
        System.out.println();

        // 큰 숫자는 메모리에 할당되어있지 않음 (주소가 다 새롭게 할당)
        System.out.println(VM.current().addressOf(300));
        System.out.println(VM.current().addressOf(300));
        System.out.println(VM.current().addressOf(new Long(300)));
        System.out.println(VM.current().addressOf(new Long(300)));
        System.out.println();

        //////////////////////////////////////////////////////////////
        ///////////////// Long -> int (UnBoxing) //////////////////
        //////////////////////////////////////////////////////////////
        Long long9 = 10L;  // boxing (특별한 함수 없이도 가능)
        long longValue = long9; // unboxing (특별한 함수 없이도 가능)
        long longValue2 = long9.longValue(); // unboxing (longValue() 함수 호출도 가능)
        System.out.println("Boxing = " + longValue);
        System.out.println("UnBoxing = " + longValue);
        System.out.println("UnBoxing = " + longValue2);
        System.out.println();

        /////////////////////////////////////////////////////////////
        ///////////////// Long 클래스 메소드 ////////////////////////
        ////////////////////////////////////////////////////////////
        System.out.println("Long.TYPE = " + Long.TYPE);
        System.out.println("Long.SIZE = " + Long.SIZE);
        System.out.println("Long.BYTES = " + Long.BYTES);
        System.out.println("Long.MAX_VALUE = " + Long.MAX_VALUE);
        System.out.println("Long.MIN_VALUE = " + Long.MIN_VALUE);
        System.out.println();

        // compare, compareUnsigned
        long s1 = -10;
        long s2 = 10;
        System.out.println("s1와 s2 비교 (signed) = " + Long.compare(s1, s2)); // -1
        System.out.println("s1와 s2 비교 (unsigned) = " + Long.compareUnsigned(s1, s2)); // 1
        System.out.println();

        // String -> int
        String str = "10";
        long parseLong = Long.parseLong(str);
        System.out.println("parseLong = " + parseLong);

        // int -> String
        long s = 10L;
        String toStringLong = Long.toString(s);
        System.out.println("toStringLong = " + toStringLong);
        System.out.println();

        // 16진수나 8진수 문자열을 10진수 정수로 바꾸기
        long decodeHex = Long.decode("0x10");
        long decodeOctal = Long.decode("010");
        System.out.println("decodeHex = " + decodeHex);
        System.out.println("decodeOctal = " + decodeOctal);
        System.out.println();

        // 10진수 정수를 2진수나, 16진수, 8진수로 바꾸기
        String binaryString = Long.toBinaryString(10);
        String hexString = Long.toHexString(10);
        String octString = Long.toOctalString(10);
        System.out.println("binaryString = " + binaryString);
        System.out.println("hexString = " + hexString);
        System.out.println("octString = " + octString);
        System.out.println();

        // max, min
        long maxValue = Long.max(1, 2); // Math.max
        long minValue = Long.min(-10, -20); // Math.min
        long sumValue = Long.sum(10, 20);
        long signum = Long.signum(-10);
        System.out.println("maxValue = " + maxValue);
        System.out.println("minValue = " + minValue);
        System.out.println("sumValue = " + sumValue);
        System.out.println("signum = " + signum);
        System.out.println();
        
        int leadingZeros = Long.numberOfLeadingZeros(10);
        int trailingZeros = Long.numberOfTrailingZeros(10);
        System.out.println("leadingZeros = " + leadingZeros); // 00000000 * 7  + 00001010
        System.out.println("trailingZeros = " + trailingZeros); // 00001010
        System.out.println();

        long reverseBytes = Long.reverseBytes(10);
        System.out.println("reverseBytes = " + reverseBytes);


    }
}
