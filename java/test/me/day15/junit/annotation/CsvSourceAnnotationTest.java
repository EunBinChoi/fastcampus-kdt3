package me.day15.junit.annotation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


class MyClass {
    private Integer value;
    private String name;
    private LocalDateTime time;
    private boolean active;

    public MyClass(Integer value, String name, LocalDateTime time, boolean active) {
        this.value = value;
        this.name = name;
        this.time = time;
        this.active = active;
    }

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "value=" + value +
                ", name='" + name + '\'' +
                ", time=" + time +
                ", active=" + active +
                '}';
    }
}

public class CsvSourceAnnotationTest {

    @DisplayName("반복 테스트")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource({"10, '자바 스터디', '2020-04-02 14:20:21', true",
            "20, 스프링, '2020-04-02 14:20:21', false"}) // 데이터 타입 동적 캐스팅
    void parameterizedTest(Integer limit,
                           String name,
                           String date,
                           boolean active) {
        MyClass myClass = new MyClass(
                limit,
                name,
                LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                active);
        assertNotNull(myClass, () -> "myClass NULL 입니다.!!!");
        System.out.println("테스트 통과 " + myClass.toString());
    }
    // ParameterizedTest
    // 1 반복 테스트 message={value=10, name='자바 스터디', time=2020-04-02T14:20:21, active=true}
    // 2 반복 테스트 message={value=10, name='자바 스터디', time=2020-04-02T14:20:21, active=true}
    // 3 반복 테스트 message={value=10, name='자바 스터디', time=2020-04-02T14:20:21, active=true}
}
