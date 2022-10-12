package me.day05.practice;

class Solution07 {
    public boolean isPalindrome(String s) {
       String str = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length()-1-i)) {
                return false;
            }
        }
        return true;
    }
}
public class Practice07 {
    public static void main(String[] args) {
        System.out.println(new Solution07().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new Solution07().isPalindrome("race a car"));
        System.out.println(new Solution07().isPalindrome(" "));
    }
}
