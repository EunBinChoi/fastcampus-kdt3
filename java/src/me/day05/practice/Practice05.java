package me.day05.practice;

class Solution05 {
    boolean solution(String s) {
        int p = 0;
        int y = 0;
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'p') {
                p++;
            } else if (s.charAt(i) == 'y') {
                y++;
            }
        }
        return p == y;
    }
}

public class Practice05 {

    public static void main(String[] args)  {
        boolean answer1 = new Solution05().solution("pPoooyY");
        boolean answer2 = new Solution05().solution("");
        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
    }
}
