package me.day12.api.lang.wrapper;

import org.openjdk.jol.vm.VM;

public class BooleanClassExample {
    public static void main(String[] args) {
        // 기초 자료형은 데이터만 저장하고 관련 함수는 없음
        // 기초 자료형과 관련 메서드를 포함하고 있는 랩퍼 클래스를 만듦
        // 랩퍼 클래스의 메소드는 대부분 static 메소드
        // byte, short, int, long, char, boolean, float, double (기초 자료형)
        // Byte, Short, Integer, Long, Character, Boolean, Float, Double (랩퍼 클래스)

        ////////////////////////////////////////////////////////////////
        /////////////////// boolean -> Boolean (Boxing) ////////////////
        ////////////////////////////////////////////////////////////////
        Boolean boolean1 = true;
        Boolean boolean2 = Boolean.valueOf("true"); // Boolean.valueOf(true)도 가능
        Boolean boolean3 = new Boolean(true);
        Boolean boolean4 = new Boolean("true");
        System.out.println(boolean1 == boolean2); // 주소 비교, true
        System.out.println(boolean3 == boolean4); // 주소 비교, false
        System.out.println(boolean1.equals(boolean2)); // 내용 비교, true
        System.out.println(boolean3.equals(boolean4)); // 내용 비교, true
        System.out.println();

        System.out.println(VM.current().addressOf(true));
        System.out.println(VM.current().addressOf(true));
        System.out.println(VM.current().addressOf("true"));
        System.out.println(VM.current().addressOf("true"));
        System.out.println(VM.current().addressOf(false));
        System.out.println(VM.current().addressOf(false));
        System.out.println(VM.current().addressOf("false"));
        System.out.println(VM.current().addressOf("false"));
        System.out.println();

        ////////////////////////////////////////////////////////////////
        /////////////////// Boolean -> boolean (UnBoxing) ////////////////
        ////////////////////////////////////////////////////////////////
        Boolean bool = true; // boxing (특별한 함수 없이도 가능)
        boolean boolValue = bool; // unboxing (특별한 함수 없이도 가능)
        boolean boolValue2 = bool.booleanValue(); // unboxing (booleanValue() 함수 호출도 가능)
        System.out.println("Boxing = " + bool);
        System.out.println("UnBoxing = " + boolValue);
        System.out.println("UnBoxing = " + boolValue2);
        System.out.println();

        /////////////////////////////////////////////////////////////
        ///////////////// Boolean 클래스 메소드 ////////////////////////
        ////////////////////////////////////////////////////////////
        System.out.println("Boolean.TYPE = " + Boolean.TYPE);
        System.out.println("Boolean.TRUE = " + Boolean.TRUE);
        System.out.println("Boolean.FALSE = " + Boolean.FALSE);
        System.out.println();

        // compare
        boolean b1 = true;
        boolean b2 = false;
        System.out.println("b1와 b2 비교 = " + Boolean.compare(b1, b2)); // true - false = 1
        System.out.println("b1와 b2 비교 = " + Boolean.compare(b2, b1)); // false - true = -1
        System.out.println();

        // String -> boolean
        String boolStr = "true";
        boolean parseBool = Boolean.parseBoolean(boolStr);
        System.out.println("parseBool = " + parseBool);

        // boolean -> String
        boolean b = false;
        String toStringBoolean = Boolean.toString(b);
        System.out.println("toStringBoolean = " + toStringBoolean);
        System.out.println();

        // logical operator
        System.out.println("Logical And = " + Boolean.logicalAnd((10 > 20), (20 > 10)));
        System.out.println("Logical Or = " + Boolean.logicalOr((10 > 20), (20 > 10)));
        System.out.println("Logical Xor = " + Boolean.logicalXor((10 > 20), (20 > 10)));
        System.out.println();

    }
}
