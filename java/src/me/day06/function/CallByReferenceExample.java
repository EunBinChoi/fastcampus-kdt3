package me.day06.function;

import java.util.Arrays;

public class CallByReferenceExample {
    public static void swap1(int[] arr) {
        // 주소값 전달 (call by reference X, call by value (address))
        int tmp = arr[0];
        arr[0] = arr[1];
        arr[1] = tmp;
        // 리턴하지 않아도 값이 바뀌어있음
    }
    public static int[] swap2(int a, int b) {
        // 변수값 전달 (call by value (data))
        int tmp = a;
        a = b;
        b = tmp;
        return new int[]{a, b};
    }
    public static void main(String[] args) {
        int[] arr = {3, 5};
        System.out.println(Arrays.toString(arr));
//        swap1(arr);
        int[] res = swap2(arr[0], arr[1]);
        System.out.println(Arrays.toString(res));
    }
}
