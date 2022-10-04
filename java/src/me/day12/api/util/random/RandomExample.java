package me.day12.api.util.random;

import java.util.Arrays;
import java.util.Random;

public class RandomExample {
    public static void main(String[] args) {
        // Random 클래스 - 난수 생성 클래스
        // Math.random()은 내부적으로 Random 인스턴스 생성해서 사용함
        // Random 객체는 seed 설정 가능 - seed 같으면 항상 같은 난수 반환
        // seed 값 디폴트 - System.currentTimeMillis() (현재 시간)

        Random random1 = new Random();
        Random random2 = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println("random1.nextInt() = " + random1.nextInt() + ", random2.nextInt() = " + random2.nextInt());
        }
        System.out.println();
        System.out.println("==========================================================================");
        System.out.println("============================ seed 동일하게 설정 =============================");
        random1.setSeed(10);
        random2.setSeed(10);
        for (int i = 0; i < 10; i++) {
            System.out.println("random1.nextInt() = " + random1.nextInt() + ", random2.nextInt() = " + random2.nextInt());
        }
        System.out.println();

        System.out.println("==========================================================================");
        System.out.println("=============================== 다양한 함수 =================================");
        Random random = new Random();
        System.out.println("random.nextBoolean() = " + random.nextBoolean());
        System.out.println("random.nextInt() = " + random.nextInt() + ", random.nextInt(100) = " + random.nextInt(100));
        System.out.println("random.nextLong() = " + random.nextLong());
        System.out.println("random.nextFloat() = " + random.nextFloat());
        System.out.println("random.nextDouble() = " + random.nextDouble());
        System.out.println("random.nextGaussian() = " + random.nextGaussian());
        System.out.println();

        byte[] bytes = new byte[10];
        System.out.println("Before - Arrays.toString(bytes) = " + Arrays.toString(bytes));
        random.nextBytes(bytes);
        System.out.println("After - Arrays.toString(bytes) = " + Arrays.toString(bytes));
    }
}
