package me.day03.random;

public class MathRandomTest{

    public static void main(String[] args){
        int dice = (int)(Math.random()*6) + 1; // 1 ~ 6
        // 0.0 <= Math.random() < 1.0
        // 0.0 <= Math.random()*6 < 6.0
        // 0 <= (int)(Math.random()*6) < 6
        // 1 <= (int)(Math.random()*6) + 1 < 7

        int month = (int)(Math.random()*11) + 1; // 1 ~ 12
        // 0.0 <= Math.random() < 1.0
        // 0.0 <= Math.random()*12 < 12.0
        // 0 <= (int)(Math.random()*12) < 12
        // 1 <= (int)(Math.random()*12) + 1 < 13
    }
}