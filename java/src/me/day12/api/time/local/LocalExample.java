package me.day12.api.time.local;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class LocalExample {
    public static void main(String[] args) {
        // https://stackoverflow.com/questions/32437550/whats-the-difference-between-instant-and-localdatetime
        // Date -> Instant -> ZonedDateTime -> LocalDate, LocalDateTime
        // 1. Date 객체 생성 (현재 날짜)
        Date date = new Date();

        // 2. Date -> LocalDate
        LocalDate localDate = date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        // 3. Date -> LocalDateTime
        LocalDateTime localDateTime = date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        // 4. Date, LocalDate, LocalDateTime
        System.out.println("date = " + date);
        System.out.println("localDate = " + localDate);
        System.out.println("localDateTime = " + localDateTime);
        System.out.println();
        System.out.println();
        ///////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////

        // Date -> java.sql.Date, java.sql.Timestamp -> LocalDate, LocalDateTime
        // 1. Date 객체 생성 (현재 날짜)
        date = new Date();

        // 2. Date -> LocalDate
        LocalDate localDateSql = new java.sql.Date(date.getTime())
                .toLocalDate();

        // 3. Date -> LocalDateTime
        LocalDateTime localDateTimeSql = new java.sql.Timestamp(date.getTime())
                .toLocalDateTime();

        // 4. Date, LocalDate, LocalDateTime
        System.out.println("date = " + date);
        System.out.println("localDateSql = " + localDateSql);
        System.out.println("localDateTimeSql = " + localDateTimeSql);
        System.out.println();
        System.out.println();
        ///////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////

        // LocalDate.ofInstant(), LocalDateTime.ofInstant() : Java 9 이상
        // 1. Date 객체 생성 (현재 날짜)
        date = new Date();

        // 2. Date -> LocalDate
        LocalDate localDateOfInstant = LocalDate.ofInstant(date.toInstant(), ZoneId.systemDefault());

        // 3. Date -> LocalDateTime
        LocalDateTime localDateTimeOfInstant = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());

        // 4. Date, LocalDate, LocalDateTime
        System.out.println("date = " + date);
        System.out.println("localDateOfInstant = " + localDateOfInstant);
        System.out.println("localDateTimeOfInstant = " + localDateTimeOfInstant);
        System.out.println();
        System.out.println();
        //////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////

        // LocalDateTime -> Date
        // 1. LocalDateTime 객체 생성 (현재 시간)
        LocalDateTime localDateTime1 = LocalDateTime.now();
        
        // 2. LocalDateTime -> Date 변환
        Date date1 = java.sql.Timestamp.valueOf(localDateTime1);
        // java.sql.Timestamp 클래스는 java.util.Date 클래스의 자식 클래스
        // Timestamp 객체를 Date 객체로 형 변환 가능 (다형성)
        
        // 3. LocalDateTime, Date 결과 출력
        System.out.println("localDateTime1 = " + localDateTime1);
        System.out.println("date1 = " + date1);
        System.out.println();
        System.out.println();
        //////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////

        // java.util.Date.from()
        // LocalDateTime -> ZonedDateTime -> Instant

        // 1. LocalDateTime 객체 생성 (현재 시간)
        LocalDateTime localDateTime2 = LocalDateTime.now();
        
        // 2. LocalDateTime -> Date 변환
        Instant instant = localDateTime2.atZone(ZoneId.systemDefault()).toInstant();
        Date date2 = Date.from(instant);
        
        // 3. LocalDateTime, Date 결과 출력
        System.out.println("localDateTime2 = " + localDateTime2);
        System.out.println("date2 = " + date2);
        System.out.println();
        System.out.println();
        //////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////

        // LocalDate -> Date
        // java.sql.Date.valueOf()

        // 1. LocalDate 객체 생성 (현재 시간)
        LocalDate localDate1 = LocalDate.now();

        // 2. LocalDate -> Date 변환
        Date date3 = java.sql.Date.valueOf(localDate1);

        // 3. LocalDate, Date 결과 출력
        System.out.println("localDate1 = " + localDate1);
        System.out.println("date3 = " + date3);
        System.out.println();
        System.out.println();
        //////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////
        
        // java.util.Date.from()
        // 1. LocalDate 객체 생성 (현재 시간)
        LocalDate localDate2 = LocalDate.now();
        
        // 2. LocalDate -> Date 변환
        Instant instant1 = localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant();
        Date date4 = Date.from(instant1);
        
        // 3. LocalDate, Date 결과 출력
        System.out.println("localDate2 = " + localDate2);
        System.out.println("date4 = " + date4);

    }
}
