package me.day12.api.lang.wrapper;

public class DoubleClassExample {
    public static void main(String[] args) {
        // 기초 자료형은 데이터만 저장하고 관련 함수는 없음
        // 기초 자료형과 관련 메서드를 포함하고 있는 랩퍼 클래스를 만듦
        // 랩퍼 클래스의 메소드는 대부분 static 메소드
        // byte, short, int, long, char, boolean, double, double (기초 자료형)
        // Byte, Short, Integer, Long, Character, Boolean, Float, Double (랩퍼 클래스)

        ////////////////////////////////////////////////////////////
        /////////////////// double -> Double (Boxing) ////////////////
        ////////////////////////////////////////////////////////////
        Double double1 = 10.34;  // 새로운 주소 할당하지 않고 기존에 저장된 10이라는 값을 가지고 옴
        Double double2 = Double.valueOf(10.34);  // 새로운 주소 할당하지 않고 기존에 저장된 10이라는 값을 가지고 옴
        Double double3 = new Double(10.34); // 객체 생성자를 통해서 사용하게 되면 새로운 주소 할당
        Double double4 = new Double(10.34); // 객체 생성자를 통해서 사용하게 되면 새로운 주소 할당
        System.out.println(double1 == double2); // 주소 비교, true
        System.out.println(double3 == double4); // 주소 비교, false
        System.out.println(double1.equals(double2)); // 내용 비교, true
        System.out.println(double3.equals(double4)); // 내용 비교, true
        System.out.println();


        //////////////////////////////////////////////////////////////
        ///////////////// Double -> double (UnBoxing) //////////////////
        //////////////////////////////////////////////////////////////
        Double doubles = 10.123456123;  // boxing (특별한 함수 없이도 가능)
        double doubleValue1 = doubles; // unboxing (특별한 함수 없이도 가능)
        double doubleValue2 = doubles.doubleValue(); // unboxing (doubleValue() 함수 호출도 가능)
        System.out.println("Boxing = " + doubles);
        System.out.println("UnBoxing = " + doubleValue1);
        System.out.println("UnBoxing = " + doubleValue2);
        System.out.println();

        /////////////////////////////////////////////////////////////
        ///////////////// Double 클래스 메소드 //////////////////////////
        ////////////////////////////////////////////////////////////
        System.out.println("Double.TYPE = " + Double.TYPE);
        System.out.println("Double.SIZE = " + Double.SIZE);
        System.out.println("Double.BYTES = " + Double.BYTES);
        System.out.println("Double.MAX_VALUE = " + Double.MAX_VALUE);
        System.out.println("Double.MIN_VALUE = " + Double.MIN_VALUE);
        System.out.println("Double.MAX_EXPONENT = " + Double.MAX_EXPONENT);
        System.out.println("Double.MIN_EXPONENT = " + Double.MIN_EXPONENT);
        System.out.println("Double.NaN = " + Double.NaN);
        System.out.println("Double.NEGATIVE_INFINITY = " + Double.NEGATIVE_INFINITY);
        System.out.println("Double.POSITIVE_INFINITY = " + Double.POSITIVE_INFINITY);
        System.out.println();


        // compare, compareTo
        double f1 = 12.34150000000001;
        double f2 = 12.3415;
        Double f3 = f1;
        Double f4 = f2;
        System.out.println("Double.compare(f1, f2) = " + Double.compare(f1, f2)); // 부동소수점 부정확함
        System.out.println("f3.compareTo(f4) = " + f3.compareTo(f4)); // 부동소수점 부정확함
        System.out.println();

        double f5 = 12.34;
        long longBits = Double.doubleToLongBits(f5);
        System.out.println("longBits = " + longBits);
        System.out.println("Double.longBitsToDouble(longBits) = " + Double.longBitsToDouble(longBits));
        System.out.println();

        double finite = 3.14;
        double infinite = 1.0 / 0.0;
        double NaN = 0.0 / 0.0;
        System.out.println("Double.isFinite(finite) = " + Double.isFinite(finite));
        System.out.println("Double.isInfinite(infinite) = " + Double.isInfinite(infinite));
        System.out.println("Double.isNaN(NaN) = " + Double.isNaN(NaN));
        System.out.println();

        // 수학 계산
        double maxValue = Double.max(3.1, 3.100000001);
        double minValue = Double.min(3.1, 3.100000001);
        double sum = Double.sum(3.14, -3.1f);
        System.out.println("maxValue = " + maxValue);
        System.out.println("minValue = " + minValue);
        System.out.println("sum = " + sum);
        System.out.println();

        // String -> double
        String str = "10.0000000001";
        double parseFloat = Double.parseDouble(str);
        System.out.println("parseFloat = " + parseFloat);

        // double -> String
        double s = 10.0000000001f;
        String toStringFloat = Double.toString(s);
        System.out.println("toStringFloat = " + toStringFloat);
        System.out.println();

        // 16진수로 바꾸기
        double hexFloat = 0.01f;
        String toHexString = Double.toHexString(hexFloat);
        System.out.println("toHexString = " + toHexString);
    }
}
