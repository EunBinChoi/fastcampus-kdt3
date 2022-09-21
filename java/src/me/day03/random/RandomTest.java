package me.day03.random;

import java.util.Random;

public class RandomTest{

    public static void main(String[] args){

        Random random = new Random();

        System.out.println( random.nextInt() );        // 1483266798 (int 표현범위 사이값)
        System.out.println( random.nextInt(10) );      // 1 (0 <= 값 < 10)
        System.out.println( random.nextInt(10) + 1 );  // 3 (1 <= 값 < 11)
        System.out.println( random.nextInt(10) * (-1) );  // -6 (-10 < 값 <= 0)
        System.out.println( random.nextBoolean() );    // false (true or false)
        System.out.println( random.nextLong() );       // -7488279853580653828 (long 표현범위 사이값)
        System.out.println( random.nextFloat() );      // 0.5873405 (float 표현범위 사이값)
        System.out.println( random.nextDouble() );		 // 0.4279275246744185 (double 표현범위 사이값)
    }
}
