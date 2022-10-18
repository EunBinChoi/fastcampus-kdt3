package me.day15.junit.lifecycle;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // 클래스 안에 객체 1개 (싱글톤)
class PerClassLiftcycleTest {
    // JUnit이 동일한 테스트 인스턴스에서 모든 테스트 메소드를 실행하도록 하는 것도 가능
    // JUnit은 테스트 클래스당 한번씩 새 테스트 인스턴스 생성 (메소드당 아님)

    public PerClassLiftcycleTest() {
        System.out.println("\tConstructor");
    }

    @BeforeAll
    void beforeTheEntireTestFixture() { // 공유 인스턴스로 인해 static일 필요 없음
        System.out.println("Before the entire test fixture");
    }

    @AfterAll
    void afterTheEntireTestFixture() { // 공유 인스턴스로 인해 static일 필요 없음
        System.out.println("After the entire test fixture");
    }

    @BeforeEach
    void beforeEachTest() {
        System.out.println("\t\tBefore each test");
    }

    @AfterEach
    void afterEachTest() {
        System.out.println("\t\tAfter each test");
    }

    @Test
    void firstTest() {
        System.out.println("\t\t\tFirst test");
    }

    @Test
    void secondTest() {
        System.out.println("\t\t\tSecond test");
    }
}