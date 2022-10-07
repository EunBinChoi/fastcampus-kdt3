package me.day12.api.time.localdatetime;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class LocalDateTimeExample3 {
    public static void main(String[] args) {
        LocalDateTime startDateTime = LocalDateTime.of(2021,1,28,9,0,0);
        System.out.println(startDateTime);

        LocalDateTime endDateTime = LocalDateTime.of(2023,3,31,18,0,0);
        System.out.println(endDateTime+"\n");

        if(startDateTime.isBefore(endDateTime)){    //이전 날짜인지 비교
            System.out.println("진행중\n");

        }else if(startDateTime.isEqual(endDateTime)){ //동일 날짜인지 비교
            System.out.println("종료하기\n");

        }else if(startDateTime.isAfter(endDateTime)){ //이후 날짜인지 비교
            System.out.println("종료됨\n");
        }

        //-------------------------------------------------------------------------------

        //종료까지 남은 시간은 두 가지 방법으로 구현 가능하다. until 메소드와 between 메소드

        System.out.println("종료까지 남은 시간");
        long remainYear = startDateTime.until(endDateTime, ChronoUnit.YEARS);   //전체 년 차이
        long remainMonth = startDateTime.until(endDateTime, ChronoUnit.MONTHS);   //전체 달 차이
        long remainWeek = startDateTime.until(endDateTime, ChronoUnit.WEEKS);   //전체 주 차이
        long remainDay = startDateTime.until(endDateTime, ChronoUnit.DAYS);   //전체 주 차이
        long remainHour = startDateTime.until(endDateTime, ChronoUnit.HOURS);   //전체 일 차이
        long remainMinute = startDateTime.until(endDateTime, ChronoUnit.MINUTES);   //전체 년 차이
        long remainSecond = startDateTime.until(endDateTime, ChronoUnit.SECONDS);   //전체 년 차이

        System.out.println("연:"+remainYear);
        System.out.println("월:"+remainMonth);
        System.out.println("주:"+remainWeek);
        System.out.println("일:"+remainDay);
        System.out.println("시간:"+remainHour);
        System.out.println("분:"+remainMinute);
        System.out.println("초:"+remainSecond);

        remainYear = ChronoUnit.YEARS.between(startDateTime, endDateTime);
        remainMonth = ChronoUnit.MONTHS.between(startDateTime, endDateTime);
        remainWeek = ChronoUnit.WEEKS.between(startDateTime, endDateTime);
        remainDay = ChronoUnit.DAYS.between(startDateTime, endDateTime);
        remainHour = ChronoUnit.HOURS.between(startDateTime, endDateTime);
        remainMinute = ChronoUnit.MINUTES.between(startDateTime, endDateTime);
        remainSecond = ChronoUnit.SECONDS.between(startDateTime, endDateTime);

        System.out.println("연:"+remainYear);
        System.out.println("월:"+remainMonth);
        System.out.println("주:"+remainWeek);
        System.out.println("일:"+remainDay);
        System.out.println("시간:"+remainHour);
        System.out.println("분:"+remainMinute);
        System.out.println("초:"+remainSecond+"\n");

        //-------------------------------------------------------------------------------

        //Priod 클래스로 날짜 차이를 구할 수 있다.
        System.out.println("종료까지 남은 기간");
        Period period = Period.between(startDateTime.toLocalDate(), endDateTime.toLocalDate());
        System.out.print("남은 기간: " + period.getYears() + "년 ");
        System.out.print(period.getMonths() + "달");
        System.out.println(period.getDays() + "일\n");

        //-------------------------------------------------------------------------------

        //Duration 클래스로 시간 차이를 구할 수 있다.
        Duration duration = Duration.between(startDateTime.toLocalTime(), endDateTime.toLocalTime());
        System.out.println("남은 초: " + duration.getSeconds());
        System.out.println("남은 나노 초: " + duration.getNano());

    }
}
