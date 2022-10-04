package me.day12.api.util.calendar;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.*;

public class CalendarExample {
    public static void main(String[] args) {
        // 특정 시간 저장하는 Calendar 클래스
        // 특정 날짜를 설정하거나 날짜 산술 수행해야하는 경우 사용
        // 지역 설정 가능
        // - Calendar 문제점
        // 1) 불변 객체 (immutable object)가 아니라서 값이 수정될 수 있음
        // 2) 윤초 (leap second)와 같은 특별한 상황 고려하지 않음
        // 3) 월 (month)을 나타낼 때 1 ~ 12월 -> 0 ~ 11까지 표현하는 불편함

        // Date 대신에 Calendar 클래스를 사용하거나 더 나은 성능의 Joda-Time 이라는 라이브러리 함께 사용함
        // Joda-Time 라이브러리 발전시켜 새로운 날짜와 시간 API인 java.time (JDK 8+) 패키지 제공

        // abstract class Calendar 추상 클래스이기 때문에 직접 new 해서 사용 불가
        // 객체 생성 방법
        // 1. Calendar.getInstance(); 이용
        // 2. Calendar 자식 클래스 GregorianCalendar, BuddhistCalendar (태국에서 이용) 클래스 이용


        ////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////
        System.out.println("============================= Calendar Field =============================");
        Calendar calendar = Calendar.getInstance();
        Calendar gregorianCalendar = new GregorianCalendar();
        System.out.println("calendar = " + calendar.getTime());
        System.out.println("gregorianCalendar = " + gregorianCalendar.getTime());
        System.out.println();

        int year = calendar.get(Calendar.YEAR); // 현재 년도
        int month = calendar.get(Calendar.MONTH); // 현재 월 (1월: 0)
        int date = calendar.get(Calendar.DATE); // 현재 월의 날짜
        int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR); // 현재 년도의 몇째 주
        int weekOfMonth = calendar.get(Calendar.WEEK_OF_MONTH); // 현재 월의 몇째 주
        int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR); // 현재 년도의 날짜
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH); // 현재 월의 날짜
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK); // 현재 요일 (일요일: 1, 토요일: 7)
        int hour = calendar.get(Calendar.HOUR); // 현재 시간 (12시간제)
        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY); // 현재 시간 (24시간제)
        int amPm = calendar.get(Calendar.AM_PM); // 오전, 오후 리턴 (오전: 0)
        int minute = calendar.get(Calendar.MINUTE); // 현재 분
        int second = calendar.get(Calendar.SECOND); // 현재 초
        int milliSecond = calendar.get(Calendar.MILLISECOND);
        int timeZone = calendar.get(Calendar.ZONE_OFFSET); // https://time.is/ko/UTC와 비교했을 때 +9시간 앞선다는 의미
        int timeDST = calendar.get(Calendar.DST_OFFSET); // https://namu.wiki/w/%EC%84%9C%EB%A8%B8%ED%83%80%EC%9E%84 서머 타임 적용 여부
        int firstDate = calendar.getActualMinimum(Calendar.DATE);
        int lastDate = calendar.getActualMaximum(Calendar.DATE);


        System.out.printf("오늘은 %d년 %d월 %d일\n", year, (month+1), date);
        System.out.printf("오늘은 올해의 %d째주, 이번달의 %d째주, %d일\n", weekOfYear, weekOfMonth, date);
        System.out.printf("오늘은 이번 해의 %d일이자, 이번 달의 %d일, 요일은 %d일 (1: 일요일)\n", dayOfYear, dayOfMonth, dayOfWeek);
        System.out.printf("현재 시각은 %d:%d:%d(%s), 24시간으로 표현하면 %d:%d:%d\n", hour, minute, second,
                (amPm == 0 ? "AM" : "PM"), hourOfDay, minute, second);
        System.out.println();

        System.out.printf("오늘은 %d년 %d월 %d일\n", year, (month+1), date);
        System.out.printf("1000분의 1초 (0 ~ 999): %d\n", milliSecond);
        System.out.printf("timeZone (-12 ~ +12): %d\n", timeZone/(60*60*1000)); // 1000분의 1초를 시간으로 표시하기 위해 60*60*1000
        System.out.printf("summerTime: %s\n", timeDST == 0 ? "not applied" : "applied"); // 1000분의 1초를 시간으로 표시하기 위해 60*60*1000
        System.out.printf("이 달의 첫째 날: %d\n", firstDate);
        System.out.printf("이 달의 마지막 날: %d\n", lastDate);
        System.out.println();
        System.out.println();
        ////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////
        System.out.println("============================= Calendar Method =============================");
        calendar = Calendar.getInstance();
        System.out.println("calendar = " + calendar.getTime());

        calendar.set(2000, 01, 01);
        System.out.println("calendar = " + calendar.getTime());
        System.out.println();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd", Locale.KOREA);
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = new GregorianCalendar(1990, 2, 20);
        Calendar calendar3 = new GregorianCalendar(2023, 2, 20);
        System.out.println("calendar1 = " + calendar1.getTime());
        System.out.println("calendar2 = " + calendar2.getTime());
        System.out.println("calendar3 = " + calendar3.getTime());

        String calendarFormat1 = simpleDateFormat.format(calendar1.getTime());
        String calendarFormat2 = simpleDateFormat.format(calendar2.getTime());
        String calendarFormat3 = simpleDateFormat.format(calendar3.getTime());
        System.out.println("calendarFormat1 = " + calendarFormat1);
        System.out.println("calendarFormat2 = " + calendarFormat2);
        System.out.println("calendarFormat3 = " + calendarFormat3);
        System.out.println();

        System.out.printf("%s.before(%s) => %b\n", calendarFormat1, calendarFormat2, calendar1.before(calendar2));
        System.out.printf("%s.after(%s) => %b\n", calendarFormat1, calendarFormat2, calendar1.after(calendar2));
        System.out.printf("%s.before(%s) => %b\n", calendarFormat1, calendarFormat3, calendar1.before(calendar3));
        System.out.printf("%s.after(%s) => %b\n", calendarFormat1, calendarFormat3, calendar1.after(calendar3));
        System.out.println();
        System.out.println();

        Calendar calendar4 = Calendar.getInstance();
        Calendar calendar5 = Calendar.getInstance();
        System.out.println("calendar4 = " + calendar4.getTime());
        System.out.println("calendar5 = " + calendar5.getTime());

        calendar4.add(Calendar.SECOND, 60);
        // add() 메소드는 전달된 일정 시간 만큼을 더하거나 빼줌
        // 다른 Calendar 필드에는 영향 줄 수 있음
        System.out.println("calendar4.add() = " + calendar4.getTime());

        calendar5.roll(Calendar.SECOND, 60);
        // roll() 메소드는 전달된 Calendar 필드에서 일정 시간 만큼을 더하거나 빼줌
        // 다른 Calendar 필드에는 영향 주지 않음
        System.out.println("calendar5.roll() = " + calendar5.getTime());
        System.out.println();
        System.out.println();

        Calendar calendar6 = Calendar.getInstance();
        System.out.println("calendar6 = " + calendar6.getTime());
        calendar6.clear(Calendar.MONTH);
        System.out.println("calendar6.clear() = " + calendar6.getTime());
        calendar6.clear();
        System.out.println("calendar6.clear() = " + calendar6.getTime());
        System.out.println();
        System.out.println();

        System.out.println("============================= TimeZone Change =============================");
        printChangedTimeZones("Asia");

    }
    private static void printChangedTimeZones(String zone) {
        Calendar changeTimeZone = Calendar.getInstance();
        System.out.println("originalTimeZone = " + changeTimeZone.getTime());

        for (String tz: TimeZone.getAvailableIDs()) {
            if (tz.startsWith(zone)) {
                TimeZone.setDefault(TimeZone.getTimeZone(tz));
                System.out.println("timeZone = " + tz);
                System.out.println("changeTimeZone = " + changeTimeZone.getTime());
                System.out.println();
            }
        }
    }
}
