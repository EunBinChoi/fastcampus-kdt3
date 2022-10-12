package me.day05.practice;

import java.io.*;
import java.util.StringTokenizer;

public class Practice04 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String read = bufferedReader.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(read);
        String A = new StringBuilder(stringTokenizer.nextToken()).reverse().toString();
        String B = new StringBuilder(stringTokenizer.nextToken()).reverse().toString();
        int numA = Integer.parseInt(A);
        int numB = Integer.parseInt(B);

        System.out.println(numA > numB ? numA : numB);

    }
}
