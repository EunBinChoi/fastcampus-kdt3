package me.day06.practice;

import java.io.*;
import java.util.Scanner;

public class Practice04 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            String score = bufferedReader.readLine();
            int count = 0;
            int sum = 0;
            for (int j = 0; j < score.length(); j++) {
                if (score.charAt(j) == 'O') {
                    count++;
                } else {
                    count = 0;
                }
                sum += count;
            }
            bufferedWriter.write(sum + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
