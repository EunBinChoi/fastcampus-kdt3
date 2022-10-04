package me.day12.api.util.locale;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

public class LocaleExample {
    public static void main(String[] args) {
        // Locale 클래스
        // 지역의 [언어][나라] 등의 정보를 담고 있는 클래스
        // language (언어코드) - ISO 639 alpha-2 https://ko.wikipedia.org/wiki/ISO_639
        // country  (나라코드) - ISO 3166-1 alpha-2 https://ko.wikipedia.org/wiki/ISO_3166-1_alpha-2

        printAvailableLocales();
        System.out.println();

        Locale localeDefault = Locale.getDefault();
        System.out.println("localeDefault = " + localeDefault);
        System.out.println();

        Locale localeJP = new Locale("ja", "JP");
        System.out.println("localeJP.getDisplayLanguage() = " + localeJP.getDisplayLanguage());
        System.out.println("localeJP.getLanguage() = " + localeJP.getLanguage());
        System.out.println("localeJP.getDisplayCountry() = " + localeJP.getDisplayCountry());
        System.out.println("localeJP.getCountry() = " + localeJP.getCountry());
        System.out.println();

        Locale localeUS = new Locale("en", "US");
        System.out.println("localeUS.getDisplayLanguage() = " + localeUS.getDisplayLanguage());
        System.out.println("localeUS.getLanguage() = " + localeUS.getLanguage());
        System.out.println("localeUS.getDisplayCountry() = " + localeUS.getDisplayCountry());
        System.out.println("localeUS.getCountry() = " + localeUS.getCountry());
        System.out.println();

        Locale localUsingStaticFieldJP = Locale.JAPAN;
        System.out.println("localUsingStaticFieldJP.getDisplayLanguage() = " + localUsingStaticFieldJP.getDisplayLanguage());
        System.out.println("localUsingStaticFieldJP.getLanguage() = " + localUsingStaticFieldJP.getLanguage());
        System.out.println("localUsingStaticFieldJP.getDisplayCountry() = " + localUsingStaticFieldJP.getDisplayCountry());
        System.out.println("localUsingStaticFieldJP.getCountry() = " + localUsingStaticFieldJP.getCountry());
        System.out.println();

        Locale localUsingStaticFieldUS = Locale.US;
        System.out.println("localUsingStaticFieldUS.getDisplayLanguage() = " + localUsingStaticFieldUS.getDisplayLanguage());
        System.out.println("localUsingStaticFieldUS.getLanguage() = " + localUsingStaticFieldUS.getLanguage());
        System.out.println("localUsingStaticFieldUS.getDisplayCountry() = " + localUsingStaticFieldUS.getDisplayCountry());
        System.out.println("localUsingStaticFieldUS.getCountry() = " + localUsingStaticFieldUS.getCountry());
        System.out.println();

        getDateWithDifferentLocales();
        System.out.println();
    }
    private static void getDateWithDifferentLocales() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(113, 8, 19, 14, 22, 30);

        Locale localeCN = Locale.SIMPLIFIED_CHINESE;
        Locale localeUS = new Locale("en", "US");

        String cn = DateFormat.getDateInstance(DateFormat.MEDIUM, localeCN).format(calendar.getTime());
        String us = DateFormat.getDateInstance(DateFormat.MEDIUM, localeUS).format(calendar.getTime());
        System.out.println("cn = " + cn);
        System.out.println("us = " + us);

    }
    private static void printAvailableLocales() {
        Locale[] locales = Locale.getAvailableLocales();
        for (Locale locale: locales) {
            System.out.print(locale + " ");
        }
        System.out.println();
    }
}
