package me.day06.practice;

import java.io.*;

public class Practice05 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter (new OutputStreamWriter(System.out));

        String word = bufferedReader.readLine().toLowerCase();
        int[] counts = new int['z' - 'a' + 1];
        char[] alpha = new char['z' - 'a' + 1];

        for (int i = 0; i < alpha.length; i++) {
            alpha[i] = (char)('a' + i);
        }

        for (int i = 0; i < word.length(); i++) {
            counts[word.charAt(i) - 'a']++;
        }

        int max = -1;
        String popular = "";
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > max) {
                max = counts[i];
                popular = Character.toString(alpha[i]).toUpperCase();
            } else if (counts[i] == max) {
                popular = "?";
            }
        }
        bufferedWriter.write(popular);
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
