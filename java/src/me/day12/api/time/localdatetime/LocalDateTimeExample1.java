package me.day12.api.time.localdatetime;

import java.time.LocalDateTime;

public class LocalDateTimeExample1 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now); //현재
        System.out.println(now.minusYears(1L)); // 년 뺴기
        System.out.println(now.minusMonths(1L)); // 달 뺴기
        System.out.println(now.minusDays(1L)); // 일 빼기
        System.out.println(now.minusWeeks(1L)); // 주 빼기
        System.out.println(now.plusYears(1L)); // 년 더하기
        System.out.println(now.plusMonths(1L)); // 달 더하기
        System.out.println(now.plusWeeks(1L)); // 주 더하기
        System.out.println(now.plusDays(1L)); // 일 더하기

        System.out.println(now.minusHours(1L)); // 시간 뺴기
        System.out.println(now.minusMinutes(1L)); // 분 빼기
        System.out.println(now.minusSeconds(1L)); // 초 빼기
        System.out.println(now.minusNanos(1L)); // 나노초 빼기
        System.out.println(now.plusHours(1L)); // 시간 더하기
        System.out.println(now.plusMinutes(1L)); // 분 더하기
        System.out.println(now.plusSeconds(1L)); // 초 더하기
        System.out.println(now.plusNanos(1L)); // 나노초 더하기

    }
}
