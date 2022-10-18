package me.day15.junit.asserts;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class AssertAllTest {
    @Test
    void test() {
        assertAll(
                () -> {
                    // executable.execute() 메소드로 실행한 다음에 timeout과 실제 실행시간을 비교하여 테스트가 실패했는지 성공했는지 여부 판단
                    // 테스트 자체가 굉장히 오래걸리는 부분을 test 해야한다면 제한시간이 있는데도 모든 테스트가 끝날때 까지 기다려야하는 단점이 존재
                    // 개발시간과 돌아가야하는 시간은 정해져 있는데 이미 타임아웃이 끝났는데도 남아있는 시간을 기다려야할 이유는 없기 때문에 이러한 점에 대해서는 아쉬운 부분
                    assertTimeout(Duration.ofMillis(100), () -> {
                        Thread.sleep(400); // 무한 루프 (테스트를 계속 기다림)
                    });
                },
                () -> {
                    // 먼저 테스트를 실행하고 테스트가 timeout 땡치는 순간 테스트를 종료시키는 메소드
                    assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
                        Thread.sleep(400); // 무한 루프 (100ms만 기다림)
                    });
                }
        );
    }
}
