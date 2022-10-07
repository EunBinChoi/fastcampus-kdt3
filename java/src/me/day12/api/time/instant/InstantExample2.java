package me.day12.api.time.instant;

import java.time.Instant;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class InstantExample2 {
    public static void main(String[] args) {
        ///////////////////////////////////////////////////////////////////////////
        // Time API의 클래스
        ///////////////////////////////////////////////////////////////////////////
        // 타임 스탬프를 다루기 위해서 사용함
        // UTC 기준으로 1970년 1월 1일 0시 0분 0초를 숫자 0으로 정하고 그로 부터 경과된 시간을 양수 또는 음수로 표현함
        // 타임스탬프는 인간에게는 직관적이지 않은 시간의 표현 방법이지만 고전적으로 기계에게는 매우 친화적인 방법으로 현재까지 널리 사용됨
        // 일단 시간을 표현하기 위해서 별도의 타입없이 기본 데이터 타입으로 표현이 가능함
        // 타임존이 UTC로 고정되어 있기 때문에 타임스탬프가 어느 타임존 기준인지를 고려할 필요 없음
        // UTC: https://time.is/ko/UTC

        System.out.println("================== Instant 클래스 ==================");

        System.out.println("1-1. 타임스탬프를 Instant로 나타내기");
        Instant epoch = Instant.EPOCH; // Instant.ofEpochSecond(0)과 동일
        System.out.println("epoch = " + epoch);

        Instant epochInFuture = Instant.ofEpochSecond(1_000_000_000);
        System.out.println("epochInFuture = " + epochInFuture);

        Instant epochInPast = Instant.ofEpochSecond(-1_000_000_000);
        System.out.println("epochInPast = " + epochInPast);
        System.out.println();
        System.out.println();

        System.out.println("1-2. 현재 시간의 타임스탬프 값을 구하기");
        Instant current = Instant.now(); // 현재 시간의 Instant 객체 반환
        System.out.println("Current Instant = "+ current);

        long epochSecond = current.getEpochSecond(); // 초 단위 타임스탬프 값
        System.out.println("Current Timestamp in seconds = " + epochSecond);

        long epochMilli = current.toEpochMilli(); // 밀리초 단위 타임스탬프 값
        System.out.println("Current Timestamp in milli seconds = " + epochMilli);
        System.out.println();
        System.out.println();

        // Instant.atZone() ↔ ZoneDateTime.toInstant()
        System.out.println("1-3. Instant와 ZonedDateTime 간 상호 변환하기");
        ZonedDateTime zdtSeoul = Year.of(2002).atMonth(6).atDay(18).atTime(20, 30).atZone(ZoneId.of("Asia/Seoul"));
        System.out.println("Time in Seoul = " + zdtSeoul);

        Instant instant = zdtSeoul.toInstant();
        System.out.println("Instant = " + instant + ", Timestamp = " + instant.getEpochSecond());

        ZonedDateTime zdtVancouver = instant.atZone(ZoneId.of("America/Vancouver"));
        // ZonedDateTime zdtVancouver = ZonedDateTime.ofInstant(instant, ZoneId.of("America/Vancouver")); 와 동일
        System.out.println("Tine in Vancouver = " + zdtVancouver);
        System.out.println();
        System.out.println();

        System.out.println("1-4. 다른 유용한 메소드들");
        Instant worldCup = Instant.ofEpochSecond(1024399800);
        System.out.println("2002 World Cup = " + worldCup);
        System.out.println("10 seconds later = " + worldCup.plusSeconds(10));
        System.out.println("10 seconds earlier = " + worldCup.minusSeconds(10));

        Instant now = Instant.now();
        System.out.println("Now = " + now);
        System.out.println("Is 2002 World Cup before now? " + worldCup.isBefore(now));
        System.out.println("Is 2002 World Cup after now? " + worldCup.isAfter(now));
    }
}
