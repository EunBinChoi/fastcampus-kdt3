package me.day12.api.time.zonedDateTime;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.TimeZone;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;

public class ZonedDateTimeExample2 {
    public static void main(String[] args){
        // 2018-03-25T01:59:59+01:00[CET]
        System.out.println(ZonedDateTime.of(LocalDateTime.of(2018, 3, 25, 1, 59, 59), ZoneId.of("CET")));
        // 2018-03-25T03:00+02:00[CET]
        System.out.println(ZonedDateTime.of(LocalDateTime.of(2018, 3, 25, 2, 0, 0), ZoneId.of("CET")));
        // 2018-10-28T02:59:59+02:00[CET]
        System.out.println(ZonedDateTime.of(LocalDateTime.of(2018, 10, 28, 2, 59, 59), ZoneId.of("CET")));
        // 2018-10-28T03:00+01:00[CET]
        System.out.println(ZonedDateTime.of(LocalDateTime.of(2018, 10, 28, 3, 0, 0), ZoneId.of("CET")));

        // DST 등등의 Time Transition Rule을 사용하지 않는 ZoneRegion이나 ZoneOffset 같은 경우에는 겨울이나 여름이나 UTC 기준 시간이 동일
        // 2018-06-01T00:00+09:00[Asia/Seoul]
        System.out.println(ZonedDateTime.of(LocalDateTime.of(2018, 6, 1, 0, 0, 0), ZoneId.of("Asia/Seoul")));
        // 2018-12-01T00:00+09:00[Asia/Seoul]
        System.out.println(ZonedDateTime.of(LocalDateTime.of(2018, 12, 1, 0, 0, 0), ZoneId.of("Asia/Seoul")));
        // 2018-06-01T00:00+09:00
        System.out.println(ZonedDateTime.of(LocalDateTime.of(2018, 6, 1, 0, 0, 0), ZoneId.of("+9")));
        // 2018-12-01T00:00+09:00
        System.out.println(ZonedDateTime.of(LocalDateTime.of(2018, 12, 1, 0, 0, 0), ZoneId.of("+9")));

        final var zonedDateTimeOfSeoul = ZonedDateTime.of(2018, 1, 1, 0, 0, 0, 0, ZoneId.of("Asia/Seoul"));
        final var zonedDateTimeOfTokyo = ZonedDateTime.of(2018, 1, 1, 0, 0, 0, 0, ZoneId.of("Asia/Tokyo"));
        // false, 둘은 다른 Region에서 사용하는 TimeZone을 사용하고 있기 때문
        System.out.println(zonedDateTimeOfSeoul.equals(zonedDateTimeOfTokyo));

        final var offsetDateTimeOfSeoul = zonedDateTimeOfSeoul.toOffsetDateTime();
        final var offsetDateTimeOfTokyo = zonedDateTimeOfTokyo.toOffsetDateTime();
        // true, 둘은 같은 Offset에 다른 Region이지만, OffsetDateTime은 ZoneRegion에 대한 정보는 없고 ZoneOffset에 대한 정보만 있기 때문에 동일한 것으로 취급
        // 같은 Region에서 사용하는 형식인지 아닌지는 알 수 없음
        System.out.println(offsetDateTimeOfSeoul.equals(offsetDateTimeOfTokyo));

        final var zonedDateTimeOfWinter = ZonedDateTime.of(2018, 1, 1, 0, 0, 0, 0, ZoneId.of("CET"));
        final var zonedDateTimeOfSummer = ZonedDateTime.of(2018, 6, 1, 0, 0, 0, 0, ZoneId.of("CET"));
        // true, 둘 다 CET라는 ZoneRegion
        System.out.println(zonedDateTimeOfWinter.getZone().equals(zonedDateTimeOfSummer.getZone()));
        // false, Offset은 겨울에는 +01:00, 여름에는 +02:00이다.
        System.out.println(zonedDateTimeOfWinter.getOffset().equals(zonedDateTimeOfSummer.getOffset()));

        final var offsetDateTimeOfWinter = zonedDateTimeOfWinter.toOffsetDateTime();
        final var offsetDateTimeOfSummer = zonedDateTimeOfSummer.toOffsetDateTime();
        // false, ZoneRegion이 없어서 ZoneOffset을 갖고 구분해야하는데 둘은 같은 Region에서 사용하는 것인데도 불구하고 다른 Offset을 가진다고 판단해서
        // OffsetDateTime만으로는 두 날짜가 같은 Region에서 사용하는 건지 아닌지를 알 수 없음
        System.out.println(offsetDateTimeOfWinter.getOffset().equals(offsetDateTimeOfSummer.getOffset()));
    }
}
