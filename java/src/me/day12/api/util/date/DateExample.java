package me.day12.api.util.date;
import java.util.Date;

public class DateExample {
    public static void main(String[] args) {
        // 특정 시간 저장하는 Date 클래스
        // 스레드에 안전하지 않음 >> java.lang.Long 선호
        // 지역 설정 불가 (절대 시점 시각을 나타내는 객체)
        // 대부분의 Date 클래스의 메소드들은 deprecated
        // 이전 버전과의 호환성을 위해 존재함

        // 특정 날짜를 설정하거나 날짜 산술 수행해야하는 경우 Calendar 클래스 사용 (지역 설정도 가능)

        System.out.println("================== Date 클래스 ==================");
        Date date = new Date();
        System.out.println("date = " + date);

        // 1970년 1월 1일 00:00:00 GMT 이후의 밀리초 수를 반환
        long time = date.getTime();
        System.out.println("time = " + time + " ms");

        boolean isBefore = date.before(new Date(2019, 1, 1));
        System.out.println("isBefore = " + isBefore);

        boolean isAfter = date.after(new Date(2019, 1, 1));
        System.out.println("isAfter = " + isAfter);
        System.out.println();
        System.out.println();

    }
}
