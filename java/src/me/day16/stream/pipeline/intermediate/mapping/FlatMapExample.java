package me.day16.stream.pipeline.intermediate.mapping;

import java.util.Arrays;
import java.util.List;

public class FlatMapExample {
    public static void main(String[] args) {
        // 입력된 데이터 (요소)들이 List<String>에 저장되어 있다고 가정하고 요소별로 단어를 뽑아 단어 스트림으로 재생성
        // 입력된 데이터들이 숫자라면 숫자를 뽑아 숫자 스트림으로 재생성할 수 있음
        List<String> inputList1 = Arrays.asList("java8 lambda", "stream mapping");
        inputList1.stream()
                .flatMap(data -> Arrays.stream(data.split(" ")))
                .forEach(word -> System.out.println(word));

        System.out.println();

        List<String> inputList2 = Arrays.asList("10, 20, 30", "40, 50, 60");
        inputList2.stream().forEach(s -> System.out.println(s));
        inputList2.stream()
                .flatMapToInt(data -> {
                    String[] strArr = data.split(",");
                    int[] intArr = new int[strArr.length];
                    for (int i = 0; i < strArr.length; i++) {
                        intArr[i] = Integer.parseInt(strArr[i].trim());
                    }
                    return Arrays.stream(intArr);
                })
                .forEach(number -> System.out.println(number + "\n"));
    }
}