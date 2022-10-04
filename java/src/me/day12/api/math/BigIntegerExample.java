package me.day12.api.math;

import java.math.BigInteger;
import java.util.Arrays;

public class BigIntegerExample {
    public static void main(String[] args) {
        /*
        * BigInteger: 정수로 표현할 수 있는 값을 넘은 수를 다룰 경우
        *
        * final int signum; // 부호 (1, 0, -1)
        * final int[] mag; // 값 (magnitude)
        *
        * 내부적으로는 int 배열을 사용해서 값을 다루기 때문에 long 타입보다 훨씬 큰 값을 다룰 수 있음
        * 하지만 성능은 떨어짐
        * final 으로 되어있기 때문에 불변 (immutable)이고 다른 모든 정수형처럼 값을 2의 보수 형태로 저장
        * */

        // BigInteger 생성
//        long longValue = 9223372036854775807;
        BigInteger bigInteger1 = new BigInteger("9223372036854775807");
        BigInteger bigInteger2 = new BigInteger("-9223372036854775807");
        BigInteger bigInteger3 = new BigInteger("FFFF", 16);
        BigInteger bigInteger4 = BigInteger.valueOf(1234567890L);
        System.out.println("bigInteger1 = " + bigInteger1);
        System.out.println("bigInteger1.signum() = " + bigInteger1.signum());
        System.out.println("bigInteger2 = " + bigInteger2);
        System.out.println("bigInteger2.signum() = " + bigInteger2.signum());
        System.out.println("bigInteger3 = " + bigInteger3);
        System.out.println("bigInteger4 = " + bigInteger4);
        System.out.println();
        ///////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////

        // BigInteger ➡️️ 다른 타입
        String string1 = bigInteger1.toString();
        String string2 = bigInteger2.toString();
        String string3 = bigInteger3.toString();
        String string4 = bigInteger4.toString(16);
        System.out.println("string1 = " + string1);
        System.out.println("string2 = " + string2);
        System.out.println("string3 = " + string3);
        System.out.println("string4 = " + string4);
        System.out.println();

        byte[] bytes1 = bigInteger1.toByteArray();
        byte[] bytes2 = bigInteger2.toByteArray();
        byte[] bytes3 = bigInteger3.toByteArray();
        byte[] bytes4 = bigInteger4.toByteArray();
        System.out.println("bytes1 = " + Arrays.toString(bytes1));
        System.out.println("bytes2 = " + Arrays.toString(bytes2));
        System.out.println("bytes3 = " + Arrays.toString(bytes3));
        System.out.println("bytes4 = " + Arrays.toString(bytes4));
        System.out.println();

        int intValue1 = bigInteger1.intValue();
        int intValue2 = bigInteger2.intValue();
        int intValue3 = bigInteger3.intValue();
        int intValue4 = bigInteger4.intValue();
        System.out.println("intValue1 = " + intValue1);
        System.out.println("intValue2 = " + intValue2);
        System.out.println("intValue3 = " + intValue3);
        System.out.println("intValue4 = " + intValue4);
        System.out.println();

        long longValue1 = bigInteger1.longValue();
        long longValue2 = bigInteger2.longValue();
        long longValue3 = bigInteger3.longValue();
        long longValue4 = bigInteger4.longValue();
        System.out.println("longValue1 = " + longValue1);
        System.out.println("longValue2 = " + longValue2);
        System.out.println("longValue3 = " + longValue3);
        System.out.println("longValue4 = " + longValue4);
        System.out.println();

        float floatValue1 = bigInteger1.floatValue();
        float floatValue2 = bigInteger2.floatValue();
        float floatValue3 = bigInteger3.floatValue();
        float floatValue4 = bigInteger4.floatValue();
        System.out.println("floatValue1 = " + floatValue1);
        System.out.println("floatValue2 = " + floatValue2);
        System.out.println("floatValue3 = " + floatValue3);
        System.out.println("floatValue4 = " + floatValue4);
        System.out.println();

        double doubleValue1 = bigInteger1.doubleValue();
        double doubleValue2 = bigInteger2.doubleValue();
        double doubleValue3 = bigInteger3.doubleValue();
        double doubleValue4 = bigInteger4.doubleValue();
        System.out.println("doubleValue1 = " + doubleValue1);
        System.out.println("doubleValue2 = " + doubleValue2);
        System.out.println("doubleValue3 = " + doubleValue3);
        System.out.println("doubleValue4 = " + doubleValue4);
        System.out.println();
        ///////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////

        // BigInteger 연산
        BigInteger add1 = bigInteger1.add(bigInteger2);
        BigInteger add2 = bigInteger3.add(bigInteger4);
        System.out.println("add1 = " + add1);
        System.out.println("add2 = " + add2);

        BigInteger sub1 = bigInteger1.subtract(bigInteger2);
        BigInteger sub2 = bigInteger3.subtract(bigInteger4);
        System.out.println("sub1 = " + sub1);
        System.out.println("sub2 = " + sub2);

        BigInteger mul1 = bigInteger1.multiply(bigInteger2);
        BigInteger mul2 = bigInteger3.multiply(bigInteger4);
        System.out.println("mul1 = " + mul1);
        System.out.println("mul2 = " + mul2);

        BigInteger div1 = bigInteger1.divide(bigInteger2);
        BigInteger div2 = bigInteger3.divide(bigInteger4);
        System.out.println("div1 = " + div1);
        System.out.println("div2 = " + div2);

        BigInteger remainder1 = bigInteger1.remainder(bigInteger2);
        BigInteger remainder2 = bigInteger3.remainder(bigInteger4);
        System.out.println("remainder1 = " + remainder1);
        System.out.println("remainder2 = " + remainder2);
        System.out.println();
        ///////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////

        // BigInteger 비트 연산 메서드
        BigInteger bigInteger = new BigInteger("11");
        System.out.println("bigInteger.toString(2) = " + bigInteger.toString(2));
        System.out.println("bigInteger.toString(2) = " + bigInteger.toString(8));
        System.out.println("bigInteger.toString(2) = " + bigInteger.toString(16));
        
        int numOfOne = bigInteger.bitCount();
        int numOfZero = bigInteger.bitLength() - numOfOne;
        System.out.println("numOfOne = " + numOfOne);
        System.out.println("numOfZero = " + numOfZero);

        boolean testBit = bigInteger.testBit(2);
        System.out.println("testBit = " + testBit);
        // val: 1 0 1 1
        // idx: 3 2 1 0

        BigInteger setBit  = bigInteger.setBit(2);
        System.out.println("setBit = " + setBit);

        BigInteger clearBit = bigInteger.clearBit(1);
        System.out.println("clearBit = " + clearBit);

        BigInteger flipBit = bigInteger.flipBit(2);
        System.out.println("flipBit = " + flipBit);
        System.out.println();
        System.out.println();

        // factorial 테스트
        for (int i = 0; i < 100; i++) {
            System.out.printf("factorial(%d) = %d \n", i, factorial(i));
            System.out.printf("factorial(%d) = %d \n", i, factorial(new BigInteger(Integer.toString(i))));
            System.out.println();
        }

    }
    public static BigInteger factorial(BigInteger n) { // n! = 1 x 2 x 3 x 4 x ... n
        if (n == null) return BigInteger.ZERO;

        if (n.equals(BigInteger.ZERO)) return BigInteger.ONE;
        else return n.multiply(factorial(n.subtract(BigInteger.ONE))); // n * factorial(n-1)
    }

    public static long factorial(long n) { // n! = 1 x 2 x 3 x 4 x ... n (20! 까지 가능)
        if (n == 0) return 1;
        else return n * factorial(n-1); // n * factorial(n-1)
    }
}
