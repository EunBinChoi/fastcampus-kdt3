package me.day15.junit.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;


// 1000원을 주면 1개의 로또를 생성해주는 클래스
public class LottoNumberGenerator { // 1 ~ 45번 6개
    public List<Integer> generate(final int money) {
        if (!isValidMoney(money)) {
            throw new RuntimeException("올바른 금액이 아닙니다.");
        }
        return generate();
    }

    private boolean isValidMoney(final int money) {
        return money == 1000;
    }

    private List<Integer> generate() {
        return new Random()
                .ints(1, 45 + 1)
                .distinct() // 중복 제거
                .limit(6) // 6개까지 만들겠다!
                .boxed() // int -> Integer
                .collect(Collectors.toList());
    }

    // 위와 같은 로또 번호 생성 코드에 대한 테스트 코드들을 작성
    // 1. 로또 번호 갯수 테스트
    // 2. 로또 번호 범위 테스트
    // 3. 잘못된 로또 금액 테스트

    @DisplayName("로또 번호 갯수 테스트")
    @Test
    void lottoNumberSizeTest() {
        // given
        final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        final int price = 1000;

        // when
        final List<Integer> lotto = lottoNumberGenerator.generate(price);

        // then
        assertEquals(lotto.size(), 6);
    }

    @DisplayName("로또 번호 범위 테스트")
    @Test
    void lottoNumberRangeTest() {
        // given
        final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        final int price = 1000;

        // when
        final List<Integer> lotto = lottoNumberGenerator.generate(price);

        // then
        assertTrue(lotto.stream().allMatch(i -> (i >= 1 && i <= 45)));

    }

    @DisplayName("잘못된 로또 금액 테스트")
    @Test
    void lottoNumberInvalidMoneyTest() {
        // given
        final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        final int price = 2000;

        // when
        final RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> lottoNumberGenerator.generate(price));

        // then
        assertEquals(exception.getMessage(), "올바른 금액이 아닙니다.");
    }

}
