package me.day16.stream.functional.pure;

public class NoSideEffect {
    public static void main(String[] args) {
        Func func = i -> i + 10;

        System.out.println(func.method(1)); // 11
        System.out.println(func.method(1)); // 11
        System.out.println(func.method(1)); // 11
        // 순수 함수에서 가장 중요한 것은 입력받은 값이 동일할 때 결과가 같아야 한다는 것
        // 매개변수로 `1`을 넣었으면 몇 번을 호출하던 `11`이 나와야 함
    }
}
