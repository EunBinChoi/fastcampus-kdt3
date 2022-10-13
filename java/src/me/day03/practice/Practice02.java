package me.day03.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice02 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("input one character => ");
        char ch = bufferedReader.readLine().charAt(0);
        if (ch >= 'a' && ch <= 'z') {
            ch -= ('a' - 'A');
        } else if (ch >= 'A' && ch <= 'Z') {
            ch += ('a' - 'A');
        } else {
            System.out.println("not valid. it is not an character.");
            return;
        }
        System.out.println("changed character = " + ch);
        
        bufferedReader.close();
    }
}
