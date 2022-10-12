package me.day05.practice;

import java.io.*;
import java.util.StringTokenizer;

public class Practice02 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter (new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());


        StringTokenizer stringTokenizer;

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int r = Integer.parseInt(stringTokenizer.nextToken());
            String s = stringTokenizer.nextToken();
            String repeat = "";

            for (int j = 0; j < s.length(); j++) {
                for (int k = 0; k < r; k++) {
                    repeat += s.charAt(j);
                }
            }
            bufferedWriter.write(repeat + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
