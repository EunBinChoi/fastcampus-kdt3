package me.day12.api.time.zonedDateTime;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.TimeZone;

public class ZonedDateTimeExample1 {
    public static void main(String[] args){
        System.out.println(Arrays.toString(TimeZone.getAvailableIDs()));
        System.out.println();

        ZonedDateTime utcDateTime = ZonedDateTime.now(ZoneId.of("UTC"));
        ZonedDateTime londonDateTime = ZonedDateTime.now(ZoneId.of("Europe/London"));
        ZonedDateTime seoulDateTime = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));

        System.out.println(utcDateTime);
        System.out.println(londonDateTime);
        System.out.println(seoulDateTime);
    }

}
