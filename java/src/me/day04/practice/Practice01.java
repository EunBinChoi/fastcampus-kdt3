package me.day04.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice01 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String answer = "";
        while (true) {
            String s = bufferedReader.readLine();
            
            if (s.charAt(0) == 'q') break;
            answer += s;
        }
        System.out.println("answer = " + answer);
        bufferedReader.close();
    }
}
