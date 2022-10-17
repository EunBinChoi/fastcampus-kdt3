package me.day15.junit.lifecycle;

import org.junit.jupiter.api.*;

class PerMethodLifecycleTest {
    // 기본적으로 JUnit은 각 테스트 메서드를 실행하기 전에 테스트 클래스의 새 인스턴스를 만듦
    // 이를 통해 개별 테스트 방법을 개별적으로 실행하고 예기치 않은 부작용을 피할 수 있음

    public PerMethodLifecycleTest() {
        System.out.println("\tConstructor");
    }

    @BeforeAll
    static void beforeTheEntireTestFixture() { // 정적으로 실행 (클래스 맨 처음에 실행되니까)
        System.out.println("Before the entire test fixture");
    }

    @AfterAll
    static void afterTheEntireTestFixture() { // 정적으로 실행 (클래스 맨 마지막에 실행되니까)
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