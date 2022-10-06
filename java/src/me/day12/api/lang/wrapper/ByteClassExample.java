package me.day12.api.lang.wrapper;

import org.openjdk.jol.vm.VM;

public class ByteClassExample {
    public static void main(String[] args) {
        // 기초 자료형은 데이터만 저장하고 관련 함수는 없음
        // 기초 자료형과 관련 메서드를 포함하고 있는 랩퍼 클래스를 만듦
        // 랩퍼 클래스의 메소드는 대부분 static 메소드
        // byte, short, int, long, char, boolean, float, double (기초 자료형)
        // Byte, Short, Integer, Long, Character, Boolean, Float, Double (랩퍼 클래스)

        ////////////////////////////////////////////////////////////
        /////////////////// byte -> Byte (Boxing) //////////////////
        ////////////////////////////////////////////////////////////
        Byte bytes1 = 10;  // 새로운 주소 할당하지 않고 기존에 저장된 10이라는 값을 가지고 옴
        Byte bytes2 = Byte.valueOf((byte)10);  // 새로운 주소 할당하지 않고 기존에 저장된 10이라는 값을 가지고 옴
        Byte bytes3 = new Byte((byte) 10); // 객체 생성자를 통해서 사용하게 되면 새로운 주소 할당
        Byte bytes4 = new Byte((byte)10); // 객체 생성자를 통해서 사용하게 되면 새로운 주소 할당
        System.out.println(bytes1 == bytes2); // 주소 비교, true
        System.out.println(bytes3 == bytes4); // 주소 비교, false
        System.out.println(bytes1.equals(bytes2)); // 내용 비교, true
        System.out.println(bytes3.equals(bytes4)); // 내용 비교, true
        System.out.println();

        // 사실 숫자 -128 ~ 127까지는 사용빈도가 높기 때문에 이미 메모리에 저장 (주소 공유)
        // 숫자, 문자, 문자열을 byte 단위로 저장하여 JVM 에게 전달
        System.out.println(VM.current().addressOf((byte) 10));
        System.out.println(VM.current().addressOf((byte) 10));
        System.out.println(VM.current().addressOf(new Byte((byte) 10)));
        System.out.println(VM.current().addressOf(new Byte((byte) 10)));
        System.out.println();

        Byte bytes5 = (byte) 300;
        Byte bytes6 = Byte.valueOf((byte) 300);
        Byte bytes7 = new Byte((byte) 300);
        Byte bytes8 = new Byte((byte) 300);
        System.out.println(bytes5 == bytes6); // 주소 비교, false
        System.out.println(bytes7 == bytes8); // 주소 비교, false
        System.out.println(bytes5.equals(bytes6)); // 내용 비교, true
        System.out.println(bytes7.equals(bytes8)); // 내용 비교, true
        System.out.println();

        // 큰 숫자는 메모리에 할당되어있지 않음 (주소가 다 새롭게 할당)
        System.out.println(VM.current().addressOf((byte) 300));
        System.out.println(VM.current().addressOf((byte) 300));
        System.out.println(VM.current().addressOf(new Byte((byte) 300)));
        System.out.println(VM.current().addressOf(new Byte((byte) 300)));
        System.out.println();

        //////////////////////////////////////////////////////////////
        ///////////////// Byte -> byte (UnBoxing) ////////////////////
        //////////////////////////////////////////////////////////////
        Byte aByte = 10;  // boxing (특별한 함수 없이도 가능)
        byte byteValue1 = aByte; // unboxing (특별한 함수 없이도 가능)
        byte byteValue2 = aByte.byteValue(); // unboxing (byteValue() 함수 호출도 가능)
        System.out.println("Boxing = " + aByte);
        System.out.println("UnBoxing = " + byteValue1);
        System.out.println("UnBoxing = " + byteValue2);
        System.out.println();

        /////////////////////////////////////////////////////////////
        ///////////////// Byte 클래스 메소드 ////////////////////////
        ////////////////////////////////////////////////////////////
        System.out.println("Byte.TYPE = " + Byte.TYPE);
        System.out.println("Byte.SIZE = " + Byte.SIZE);
        System.out.println("Byte.BYTES = " + Byte.BYTES);
        System.out.println("Byte.MAX_VALUE = " + Byte.MAX_VALUE);
        System.out.println("Byte.MIN_VALUE = " + Byte.MIN_VALUE);
        System.out.println();

        // compare, compareUnsigned
        byte s1 = -10;
        byte s2 = 10;
        System.out.println("s1와 s2 비교 (signed) = " + Byte.compare(s1, s2));
        System.out.println("s1와 s2 비교 (unsigned) = " + Byte.compareUnsigned(s1, s2));
        System.out.println();

        // String -> int
        String str = "10";
        byte parseByte = Byte.parseByte(str);
        System.out.println("parseByte = " + parseByte);

        // int -> String
        byte s = 10;
        String toStringByte = Byte.toString(s);
        int toUnsignedInt = Byte.toUnsignedInt(s);
        long toUnsignedLong = Byte.toUnsignedLong(s);
        System.out.println("toStringByte = " + toStringByte);
        System.out.println("toUnsignedInt = " + toUnsignedInt);
        System.out.println("toUnsignedLong = " + toUnsignedLong);
        System.out.println();

        // 16진수나 8진수 문자열을 10진수 정수로 바꾸기
        byte decodeHex = Byte.decode("0x10");
        byte decodeOctal = Byte.decode("010");
        System.out.println("decodeHex = " + decodeHex);
        System.out.println("decodeOctal = " + decodeOctal);
        System.out.println();

    }
}
