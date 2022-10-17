package me.day16.stream.pipeline.terminal.aggregate.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class NoSuchElementExceptionExample {
    public static void main(String[] args) {
        // 컬렉션의 요소는 동적으로 추가되는 경우가 많음
        // 만약 아래 코드와 같이 컬렉션의 요소가 추가되지 않아 저장된 요소가 없을 경우
        List<Integer> list = new ArrayList<>();
//        double avg = list.stream()
//                .mapToInt(i-> Integer.valueOf(i))
//                .average()
//                .getAsDouble();
//        System.out.println(avg);
        // (요소가 없으므로) 당연히 평균값도 없기 때문에 NoSuchElementException 예외가 발생

        ////////////////////////////////////////////////////////
        // 해결방법
        // 1. Optional 객체를 얻어 isPresent()메소드로 평균값 여부 확인
        OptionalDouble optional = list.stream()
                .mapToInt(Integer :: intValue)
                .average();
        System.out.println(optional.isPresent() ? optional.getAsDouble() : "0.0");

        // 2. orElse() 메소드로 디폴트 값 정해놓기
        double avg = list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
        System.out.println(avg);
//
        // 3. ifPresent() 메소드로 평균값이 있을 경우에만 값을 이용하는 람다식 실행
        list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .ifPresent(System.out::println); // 메소드 참조
        //      .ifPresent(s -> System.out.println(s))
    }
}
