package me.day12.api.lang.math;

public class MathExample {
    public static void main(String[] args) {
        double E = Math.E;
        double PI = Math.PI;
        System.out.println("E = " + E);
        System.out.println("PI = " + PI);
        System.out.println();

        int random1 = (int)(Math.random() * 100);       // 0   <=   < 100
        int random2 = (int)(Math.random() * 100) + 10;  // 10  <=   < 110
        int random3 = (int)(Math.random() * 100) + 100; // 100 <=   < 200
        int random4 = (int)(Math.random() * 6) + 1;     // 1   <=   < 7
        System.out.println("random1 = " + random1);
        System.out.println("random2 = " + random2);
        System.out.println("random3 = " + random3);
        System.out.println("random4 = " + random4);
        System.out.println();

        System.out.println("Math.abs(-10) = " + Math.abs(-10));
        System.out.println("Math.abs(10) = " + Math.abs(10));
        System.out.println("Math.abs(-3.14) = " + Math.abs(-3.14));
        System.out.println("Math.abs(3.14) = " + Math.abs(3.14));
        System.out.println();

        System.out.println("Math.ceil(10.0) = " + Math.ceil(10.0));
        System.out.println("Math.ceil(10.1) = " + Math.ceil(10.1));
        System.out.println("Math.ceil(10.000001) = " + Math.ceil(10.000001));

        System.out.println("Math.floor(10.0) = " + Math.floor(10.0));
        System.out.println("Math.floor(10.9) = " + Math.floor(10.9));

        System.out.println("Math.round(10.0) = " + Math.round(10.0));
        System.out.println("Math.round(10.4) = " + Math.round(10.4));
        System.out.println("Math.round(10.5) = " + Math.round(10.5));
        System.out.println();

        System.out.println("Math.max(3.14, 3.14159) = " + Math.max(3.14, 3.14159)); // 3.14159
        System.out.println("Math.min(3.14, 3.14159) = " + Math.min(3.14, 3.14159)); // 3.14
        System.out.println("Math.max(-10, -11) = " + Math.max(-10, -11));      // -10
        System.out.println("Math.min(-10, -11) = " + Math.min(-10, -11));      // -11
        System.out.println();

        System.out.println("Math.pow(5, 2) = " + Math.pow(5, 2));
        System.out.println("Math.sqrt(10) = " + Math.sqrt(10));
        System.out.println();

        // 컴퓨터의 실수는 정확하지 않음
        // 부동 소수점의 한계
        System.out.println("Math.sin(Math.toRadians(30)) = " + Math.sin(Math.toRadians(30)));
        System.out.println("Math.sin(Math.PI / 6) = " + Math.sin(Math.PI / 6));

        System.out.println("Math.tan(Math.toRadians(45)) = " + Math.tan(Math.toRadians(45)));
        System.out.println("Math.tan(Math.PI / 4) = " + Math.tan(Math.PI / 4));

        System.out.println("Math.cos(Math.toRadians(60)) = " + Math.cos(Math.toRadians(60)));
        System.out.println("Math.cos(Math.PI / 3) = " + Math.cos(Math.PI / 3));

    }
}
