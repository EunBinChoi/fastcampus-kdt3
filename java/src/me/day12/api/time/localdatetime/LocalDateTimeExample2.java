package me.day12.api.time.localdatetime;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

public class LocalDateTimeExample2 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);


        //직접 변경
        LocalDateTime target = now
                .withYear(2024)     //년 변경
                .withMonth(10)      //월 변경
                .withDayOfMonth(5)  //월의 일 변경
                .withHour(13)       //시간 변경
                .withMinute(30)     //분 변경
                .withSecond(20)     //초 변경
                .withNano(300);     //나노초 변경

        System.out.println(target);

        //년의 일 변경(1월 1일 기준으로 매개변수 만큼 더한 날을 출력)
        target = target.withDayOfYear(350);
        System.out.println(target);

        // 연도 상대 변경
        // With(TemporalAdjuster adjuster) 메소드
        // 현재 날짜를 기준으로 해의 첫 번째 일 또는 마지막 일, 달의 첫 번째 일 또는 마지막 일,
        // 달의 첫 번째 요일, 지난 요일 및 돌아오는 요일 등 상대적인 날짜를 리턴
        target = now.with(TemporalAdjusters.firstDayOfYear()); //이번 해의 첫 일
        System.out.println(target);

        target = now.with(TemporalAdjusters.lastDayOfYear()); //이번 해의 마지막 일
        System.out.println(target);

        target = now.with(TemporalAdjusters.firstDayOfNextYear()); //다음 해의 첫 일
        System.out.println(target);

        //월 상대 변경
        target = now.with(TemporalAdjusters.firstDayOfMonth()); //이번 달의 첫 일
        System.out.println(target);

        target = now.with(TemporalAdjusters.lastDayOfYear()); //이번 달의 마지막 일
        System.out.println(target);

        target = now.with(TemporalAdjusters.firstDayOfNextMonth()); //다음 달의 첫 일
        System.out.println(target);

        //요일 상대 변경
        target = now.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)); //이번 달의 첫 월요일
        System.out.println(target);

        target = now.with(TemporalAdjusters.next(DayOfWeek.MONDAY)); //돌아오는 월요일
        System.out.println(target);

        target = now.with(TemporalAdjusters.previous(DayOfWeek.MONDAY)); //지난 월요일
        System.out.println(target);

    }
}
