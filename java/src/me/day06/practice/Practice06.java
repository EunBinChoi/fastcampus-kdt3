package me.day06.practice;

import java.util.Arrays;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            String binaryString = Integer.toBinaryString(arr1[i] | arr2[i]);
            binaryString = String.format("%" + n + "s", binaryString);
            binaryString = binaryString.replace("1", "#");
            binaryString = binaryString.replace("0", " ");
            answer[i] = binaryString;
        }

        return answer;
    }
}

public class Practice06 {
    public static void main(String[] args) {
        String[] answer = new Solution().solution(5, new int[] {9, 20, 28, 18, 11}, new int[] {30, 1, 21, 17, 28});
        System.out.println(Arrays.toString(answer));

        String[] answer2 = new Solution().solution(6, new int[] {46, 33, 33, 22, 31, 50}, new int[] {27, 56, 19, 14, 14, 10});
        System.out.println(Arrays.toString(answer2));
    }
}


