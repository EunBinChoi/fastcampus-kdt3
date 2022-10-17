package me.day15.junit.annotation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ValueSourceAnnotationTest {

    @DisplayName("반복 테스트")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(ints = {10, 20, 30}) // 단 1개의 타입만 넘겨야함
    void parameterizedTest(int value) {
        assertTrue(value > 0, () -> "인수는 양수여야 합니다.");
        System.out.println("테스트 통과");
    }
    // ParameterizedTest
    // 1 반복 테스트 message=10
    // 2 반복 테스트 message=20
    // 3 반복 테스트 message=30
}
