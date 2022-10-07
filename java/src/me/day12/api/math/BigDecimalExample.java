package me.day12.api.math;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

public class BigDecimalExample {
    public static void main(String[] args) {
        /*
        * BigDecimal: 정수를 이용해서 실수를 표현
        *
        * private final BigInteger intVal; // 정수 (unscaled value)
        * private final int scale; // 지수 (scale)
        * private transient int precision; // 정밀도 (precision) 정수의 자리수
        * (cf) transient: Serialize하는 과정에 제외하고 싶은 변수 앞에 선언함 (보안상의 이유로)
        *               : 필드는 유지되지만 null로 초기화됨
        *               : 데이터 제외시 서비스 장애 이상이 없는지 고려해서 제외해야 함
        *
        * 실수의 오차는 10진 실수를 2진 실수로 정확히 변환할 수 없는 경우가 있기 때문에 발생하는 것임
        * 오차가 없는 2진 정수로 변환해서 다룰 수 있음 => 정수 x 10^(-scale)
        *
        * final 으로 되어있기 때문에 불변 (immutable)임
        * BigDecimal은 정수를 저장하는데 BigInteger을 사용함
        * */
        
        // BigDecimal 분석
        double doubleValue1 = 123.45;
        System.out.println("doubleValue1 = " + doubleValue1);
        BigDecimal bigDecimal1 = new BigDecimal("123.45"); // 12345 x 10^(-2)
        System.out.println("bigDecimal1 = " + bigDecimal1);
        System.out.println("bigDecimal1.unscaledValue() = " + bigDecimal1.unscaledValue());
        System.out.println("bigDecimal1.scale() = " + bigDecimal1.scale());
        System.out.println("bigDecimal1.precision() = " + bigDecimal1.precision());
        System.out.println();

        double doubleValue2 = 123.45123124123123123123123123; // 소수점 아래 14자리까지만 표현됨
        System.out.println("doubleValue2 = " + doubleValue2);
        BigDecimal bigDecimal2 = new BigDecimal("123.45123124123123123123123123"); // 12345 x 10^(-2)
        System.out.println("bigDecimal2 = " + bigDecimal2);
        System.out.println("bigDecimal2.unscaledValue() = " + bigDecimal2.unscaledValue());
        System.out.println("bigDecimal2.scale() = " + bigDecimal2.scale());
        System.out.println("bigDecimal2.precision() = " + bigDecimal2.precision());
        System.out.println();
        ////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////

        // BigDecimal 생성
        BigDecimal bigDecimal3 = new BigDecimal("123.4567890");
        BigDecimal bigDecimal4 = new BigDecimal(123.4567890); // BigDecimal(double)은 double가 부정확하기 때문에 예측 불가
        BigDecimal bigDecimal5 = new BigDecimal(1234567890);
        BigDecimal bigDecimal6 = BigDecimal.valueOf(123.4567890); // 만약 double을 인자로 주고 싶을 경우 valueOf(double) 사용
        BigDecimal bigDecimal7 = BigDecimal.valueOf(1234567890);
        System.out.println("bigDecimal3 = " + bigDecimal3);
        System.out.println("bigDecimal4 = " + bigDecimal4);
        System.out.println("bigDecimal5 = " + bigDecimal5);
        System.out.println("bigDecimal6 = " + bigDecimal6);
        System.out.println("bigDecimal7 = " + bigDecimal7);
        System.out.println();
        ////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////

        // BigDecimal ➡️️ String
        BigDecimal bigDecimal8 = new BigDecimal(1.0e-30); // 지수를 이용해서 초기화 가능
        String string1 = bigDecimal8.toString(); // 생성자로 전달받은 값 그대로 반환
        String plainString1 = bigDecimal8.toPlainString(); // 생성자로 전달받은 값을 지수표현없이 반환
        String engineerString1 = bigDecimal8.toEngineeringString(); // 지수표현이 있으면 엔지니어링 표기법으로 반환 (거듭제곱이 3의 배수)
        System.out.println("string1         = " + string1);
        System.out.println("plainString1    = " + plainString1);
        System.out.println("engineerString1 = " + engineerString1);
        System.out.println();

        BigDecimal bigDecimal9 = new BigDecimal(0.0001e-20); // 지수를 이용해서 초기화 가능
        String string2 = bigDecimal9.toString(); // 생성자로 전달받은 값 그대로 반환
        String plainString2 = bigDecimal9.toPlainString(); // 생성자로 전달받은 값을 지수표현없이 반환
        String engineerString2 = bigDecimal9.toEngineeringString(); // 지수표현이 있으면 엔지니어링 표기법으로 반환 (거듭제곱이 3의 배수)
        System.out.println("string2         = " + string2);
        System.out.println("plainString2    = " + plainString2);
        System.out.println("engineerString2 = " + engineerString2);
        System.out.println();
        ////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////

        // BigDecimal ➡️️ 다른 타입
        BigDecimal bigDecimal10 = new BigDecimal("123.45123124123123123123123123");
        BigDecimal bigDecimal11 = new BigDecimal(123.45123124123123123123123123); // BigDecimal(double)은 double가 부정확하기 때문에 예측 불가
        BigDecimal bigDecimal12 = new BigDecimal(1234567890);
        BigDecimal bigDecimal13 = BigDecimal.valueOf(123.45123124123123123123123123); // 만약 double을 인자로 주고 싶을 경우 valueOf(double) 사용
        BigDecimal bigDecimal14 = BigDecimal.valueOf(1234567890);
        System.out.println("bigDecimal10 = " + bigDecimal10);
        System.out.println("bigDecimal11 = " + bigDecimal11);
        System.out.println("bigDecimal12 = " + bigDecimal12);
        System.out.println("bigDecimal13 = " + bigDecimal13);
        System.out.println("bigDecimal14 = " + bigDecimal14);
        System.out.println();

        byte byte10 = bigDecimal10.byteValue();
        byte byte11 = bigDecimal11.byteValue();
        byte byte12 = bigDecimal12.byteValue();
        byte byte13 = bigDecimal13.byteValue();
        byte byte14 = bigDecimal14.byteValue();
        System.out.println("byte10 = " + byte10);
        System.out.println("byte11 = " + byte11);
        System.out.println("byte12 = " + byte12);
        System.out.println("byte13 = " + byte13);
        System.out.println("byte14 = " + byte14);
        System.out.println();

        int intValue10 = bigDecimal10.intValue();
        int intValue11 = bigDecimal11.intValue();
        int intValue12 = bigDecimal12.intValue();
        int intValue13 = bigDecimal13.intValue();
        int intValue14 = bigDecimal14.intValue();
        System.out.println("intValue10 = " + intValue10);
        System.out.println("intValue11 = " + intValue11);
        System.out.println("intValue12 = " + intValue12);
        System.out.println("intValue13 = " + intValue13);
        System.out.println("intValue14 = " + intValue14);
        System.out.println();

        long longValue10 = bigDecimal10.longValue();
        long longValue11 = bigDecimal11.longValue();
        long longValue12 = bigDecimal12.longValue();
        long longValue13 = bigDecimal13.longValue();
        long longValue14 = bigDecimal14.longValue();
        System.out.println("longValue10 = " + longValue10);
        System.out.println("longValue11 = " + longValue11);
        System.out.println("longValue12 = " + longValue12);
        System.out.println("longValue13 = " + longValue13);
        System.out.println("longValue14 = " + longValue14);
        System.out.println();

        float floatValue10 = bigDecimal10.floatValue();
        float floatValue11 = bigDecimal11.floatValue();
        float floatValue12 = bigDecimal12.floatValue();
        float floatValue13 = bigDecimal13.floatValue();
        float floatValue14 = bigDecimal14.floatValue();
        System.out.println("floatValue10 = " + floatValue10);
        System.out.println("floatValue11 = " + floatValue11);
        System.out.println("floatValue12 = " + floatValue12);
        System.out.println("floatValue13 = " + floatValue13);
        System.out.println("floatValue14 = " + floatValue14);
        System.out.println();

        double doubleValue10 = bigDecimal10.doubleValue();
        double doubleValue11 = bigDecimal11.doubleValue();
        double doubleValue12 = bigDecimal12.doubleValue();
        double doubleValue13 = bigDecimal13.doubleValue();
        double doubleValue14 = bigDecimal14.doubleValue();
        System.out.println("doubleValue10 = " + doubleValue10);
        System.out.println("doubleValue11 = " + doubleValue11);
        System.out.println("doubleValue12 = " + doubleValue12);
        System.out.println("doubleValue13 = " + doubleValue13);
        System.out.println("doubleValue14 = " + doubleValue14);
        System.out.println();

        BigInteger bigInteger10 = bigDecimal10.toBigInteger();
        BigInteger bigInteger11 = bigDecimal11.toBigInteger();
        BigInteger bigInteger12 = bigDecimal12.toBigInteger();
        BigInteger bigInteger13 = bigDecimal13.toBigInteger();
        BigInteger bigInteger14 = bigDecimal14.toBigInteger();
        System.out.println("bigInteger10 = " + bigInteger10);
        System.out.println("bigInteger11 = " + bigInteger11);
        System.out.println("bigInteger12 = " + bigInteger12);
        System.out.println("bigInteger13 = " + bigInteger13);
        System.out.println("bigInteger14 = " + bigInteger14);
        System.out.println();
        ///////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////

        // BigDecimal 연산
        BigDecimal bigDecimal15 = new BigDecimal("123.456");
        BigDecimal bigDecimal16 = new BigDecimal("0.1");
        BigDecimal add = bigDecimal15.add(bigDecimal16);
        BigDecimal sub = bigDecimal15.subtract(bigDecimal16);
        BigDecimal mul = bigDecimal15.multiply(bigDecimal16);
        BigDecimal div = bigDecimal15.divide(bigDecimal16);
        BigDecimal remainder = bigDecimal15.remainder(bigDecimal16);
        System.out.println("bigDecimal15 = " + bigDecimal15 + ", bigDecimal15.unscaledValue() = " +
                bigDecimal15.unscaledValue() + ", bigDecimal15.scale() = " + bigDecimal15.scale() + ", bigDecimal15.precision() = " + bigDecimal15.precision());
        System.out.println("bigDecimal16 = " + bigDecimal16 + ", bigDecimal16.unscaledValue() = " +
                bigDecimal16.unscaledValue() + ", bigDecimal16.scale() = " + bigDecimal16.scale() + ", bigDecimal16.precision() = " + bigDecimal16.precision());
        System.out.println("=============================================================================================================");
        System.out.println("add = " + add + ", add.unscaledValue() = " + add.unscaledValue() + ", add.scale() = " + add.scale() + ", add.precision() = " + add.precision());
        System.out.println("sub = " + sub + ", sub.unscaledValue() = " + sub.unscaledValue() + ", sub.scale() = " + sub.scale() + ", sub.precision() = " + sub.precision());
        System.out.println("mul = " + mul + ", mul.unscaledValue() = " + mul.unscaledValue() + ", mul.scale() = " + mul.scale() + ", mul.precision() = " + mul.precision());
        System.out.println("div = " + div + ", div.unscaledValue() = " + div.unscaledValue() + ", div.scale() = " + div.scale() + ", div.precision() = " + div.precision());
        System.out.println("remainder = " + remainder + ", remainder.unscaledValue() = " + remainder.unscaledValue() + ", remainder.scale() = " + remainder.scale() + ", remainder.precision() = " + remainder.precision());
        System.out.println();
        ///////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////

        // 반올림 모드 (divide(), setScale())
        // roundingMode - 나눗셈 결과 어떻게 반올림 할 것인가
        // - CEILING: 올림
        // - FLOOR: 내림
        // - UP: 양수일 때는 올림, 음수일 때는 내림
        // - DOWN: 양수일 때는 내림, 음수일 때는 내림
        // - HALF_UP: 반올림 (5이상 올림, 5미만 버림)
        // - HALF_EVEN: 반올림 (반올림 자리의 값이 짝수면 HALF_DOWN, 홀수면 HALF_UP)
        // - HALF_DOWN: 반올림 (6이상 올림, 6미만 버림)
        // - UNNECESSARY: 나눗셈 결과가 딱 떨어지는 수가 아니면 ArithmeticException 발생
        // (*) divide()한 나눗셈 결과가 무한 소수인 경우, 반올림 모드를 지정해주지 않으면 ArithmeticException 발생
        BigDecimal bigDecimal17 = new BigDecimal("123.4567890");
        BigDecimal bigDecimal18 = new BigDecimal("0.1");
        System.out.println("bigDecimal17 = " + bigDecimal17);
        System.out.println("bigDecimal18 = " + bigDecimal18);
        BigDecimal divide1 = bigDecimal17.divide(bigDecimal18, 2, RoundingMode.HALF_UP); // 정밀도 2에서 반올림
        BigDecimal divide2 = bigDecimal17.divide(bigDecimal18, new MathContext(2, RoundingMode.HALF_UP)); // 정밀도 2에서 반올림
        System.out.println("divide1 = " + divide1);
        System.out.println("divide2 = " + divide2.toPlainString());


    }
}
