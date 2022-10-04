package me.day12.api.text.decimalformat;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class DecimalFormatExample {
    public static void main(String[] args) throws ParseException {
        double number1 = 12345.678;
        NumberFormat defaultFormat = NumberFormat.getNumberInstance();
        NumberFormat spanishFormat = NumberFormat.getInstance(new Locale("es", "ES"));
        NumberFormat japaneseFormat = NumberFormat.getInstance(Locale.JAPAN);

        String defaultNumber = defaultFormat.format(number1);
        String spanishNumber = spanishFormat.format(number1);
        String japaneseNumber = japaneseFormat.format(number1);
        System.out.println("defaultNumber = " + defaultNumber + " " + defaultFormat.getCurrency().getSymbol());
        System.out.println("spanishNumber = " + spanishNumber + " " + spanishFormat.getCurrency().getSymbol());
        System.out.println("japaneseNumber = " + japaneseNumber + " " + japaneseFormat.getCurrency().getSymbol());


        DecimalFormat decimalFormat = new DecimalFormat();
        Number number2 = decimalFormat.parse("123,456,789");
        System.out.println("number2 = " + number2);
        System.out.println();
        /////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////

        DecimalFormat decimalFormat1 = new DecimalFormat();
        String[] patterns = {
                "0",
                "#",
                "0.0",
                "000.000",				//소수점
                "000,000,000.0",
                "000,000,000.000",
                "000,000,000.000000",	//숫자가 나타나지 않는 경우 나머지 빈자리를 0으로 채워줌
                "#,#,#,#.###",			//한글자씩 ,이 붙어서 나옴
                "###,###,###.#",
                "###,###,###.###",
                "###,###,###.######",
                "-###,###,###.######",	// 숫자가 나타나지 않는 경우 출력하지 않음
                "###.##E0",				// 지수 형식으로 출력
                "double value: ###.##%",	// double value 라는 문자열이 합쳐짐
                "'#' ###,###.####",		// escape 로 #을 문자화
                "'0' 000,000.00000000",	// escape 로 0을 문자화
                "###,###.000000000"	// 섞어서도 쓸 수 있음
        };

        double doubleValue = 1234123123.1234;

        for(int i = 0; i < patterns.length ; i++) {
            decimalFormat1.applyPattern(patterns[i]);
            System.out.println("[pattern " + patterns[i] + "] " + decimalFormat1.format(doubleValue));
        }
    }
}
