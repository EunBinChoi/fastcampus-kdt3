package me.day06.practice;

public class Practice02 {
    public static void main(String[] args) {
        final int MAX_NUM = 100;
        int[] nums = new int[MAX_NUM];

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int)(Math.random() * 100) + 1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) { max = nums[i]; }
            if (nums[i] < min) { min = nums[i]; }
        }

        System.out.println("max = " + max);
        System.out.println("min = " + min);

    }
}
