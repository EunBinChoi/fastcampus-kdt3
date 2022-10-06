package me.day12.api.lang.wrapper;

public class FloatClassExample {
    public static void main(String[] args) {
        // 기초 자료형은 데이터만 저장하고 관련 함수는 없음
        // 기초 자료형과 관련 메서드를 포함하고 있는 랩퍼 클래스를 만듦
        // 랩퍼 클래스의 메소드는 대부분 static 메소드
        // byte, short, int, long, char, boolean, float, double (기초 자료형)
        // Byte, Short, Integer, Long, Character, Boolean, Float, Double (랩퍼 클래스)

        ////////////////////////////////////////////////////////////
        /////////////////// float -> Integer (Boxing) ////////////////
        ////////////////////////////////////////////////////////////
        Float float1 = 10.34f;  // 새로운 주소 할당하지 않고 기존에 저장된 10이라는 값을 가지고 옴
        Float float2 = Float.valueOf(10.34f);  // 새로운 주소 할당하지 않고 기존에 저장된 10이라는 값을 가지고 옴
        Float float3 = new Float(10.34f); // 객체 생성자를 통해서 사용하게 되면 새로운 주소 할당
        Float float4 = new Float(10.34f); // 객체 생성자를 통해서 사용하게 되면 새로운 주소 할당
        System.out.println(float1 == float2); // 주소 비교, true
        System.out.println(float3 == float4); // 주소 비교, false
        System.out.println(float1.equals(float2)); // 내용 비교, true
        System.out.println(float3.equals(float4)); // 내용 비교, true
        System.out.println();


        //////////////////////////////////////////////////////////////
        ///////////////// Float -> float (UnBoxing) //////////////////
        //////////////////////////////////////////////////////////////
        Float floats = 10.123456123f;  // boxing (특별한 함수 없이도 가능)
        float floatValue1 = floats; // unboxing (특별한 함수 없이도 가능)
        float floatValue2 = floats.floatValue(); // unboxing (floatValue() 함수 호출도 가능)
        System.out.println("Boxing = " + floats);
        System.out.println("UnBoxing = " + floatValue1);
        System.out.println("UnBoxing = " + floatValue2);
        System.out.println();

        /////////////////////////////////////////////////////////////
        ///////////////// Float 클래스 메소드 //////////////////////////
        ////////////////////////////////////////////////////////////
        System.out.println("Float.TYPE = " + Float.TYPE);
        System.out.println("Float.SIZE = " + Float.SIZE);
        System.out.println("Float.BYTES = " + Float.BYTES);
        System.out.println("Float.MAX_VALUE = " + Float.MAX_VALUE);
        System.out.println("Float.MIN_VALUE = " + Float.MIN_VALUE);
        System.out.println("Float.MAX_EXPONENT = " + Float.MAX_EXPONENT);
        System.out.println("Float.MIN_EXPONENT = " + Float.MIN_EXPONENT);
        System.out.println("Float.NaN = " + Float.NaN);
        System.out.println("Float.NEGATIVE_INFINITY = " + Float.NEGATIVE_INFINITY);
        System.out.println("Float.POSITIVE_INFINITY = " + Float.POSITIVE_INFINITY);
        System.out.println();


        // compare, compareTo
        float f1 = 12.34150000000001f;
        float f2 = 12.3415f;
        Float f3 = f1;
        Float f4 = f2;
        System.out.println("Float.compare(f1, f2) = " + Float.compare(f1, f2)); // 부동소수점 부정확함
        System.out.println("f3.compareTo(f4) = " + f3.compareTo(f4)); // 부동소수점 부정확함
        System.out.println();

        float f5 = 12.34f;
        int intBits = Float.floatToIntBits(f5);
        System.out.println("intBits = " + intBits);
        System.out.println("Float.intBitsToFloat(intBits) = " + Float.intBitsToFloat(intBits));
        System.out.println();

        float finite = 3.14f;
        float infinite = 1.0f / 0.0f;
        float NaN = 0.0f / 0.0f;
        System.out.println("Float.isFinite(finite) = " + Float.isFinite(finite));
        System.out.println("Float.isInfinite(infinite) = " + Float.isInfinite(infinite));
        System.out.println("Float.isNaN(NaN) = " + Float.isNaN(NaN));
        System.out.println();

        // 수학 계산
        float maxValue = Float.max(3.1f, 3.100000001f);
        float minValue = Float.min(3.1f, 3.100000001f);
        float sum = Float.sum(3.14f, -3.1f);
        System.out.println("maxValue = " + maxValue);
        System.out.println("minValue = " + minValue);
        System.out.println("sum = " + sum);
        System.out.println();

        // String -> float
        String str = "10.0000000001";
        float parseFloat = Float.parseFloat(str);
        System.out.println("parseFloat = " + parseFloat);

        // float -> String
        float s = 10.0000000001f;
        String toStringFloat = Float.toString(s);
        System.out.println("toStringFloat = " + toStringFloat);
        System.out.println();

        // 16진수로 바꾸기
        float hexFloat = 0.01f;
        String toHexString = Float.toHexString(hexFloat);
        System.out.println("toHexString = " + toHexString);
    }
}
