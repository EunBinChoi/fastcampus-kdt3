package me.day05.practice;

import java.io.*;
import java.util.StringTokenizer;

public class Practice03 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String sentence = bufferedReader.readLine().strip();
        StringTokenizer stringTokenizer = new StringTokenizer(sentence);
        System.out.println(stringTokenizer.countTokens());
    }
}
