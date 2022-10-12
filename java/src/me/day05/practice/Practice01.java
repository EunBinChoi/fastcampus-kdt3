package me.day05.practice;

import java.io.*;

public class Practice01 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter (new OutputStreamWriter(System.out));

        String message = bufferedReader.readLine();
        String[] messages = message.split(" ");
        String decodeMessage = "";
        for (int i = 0; i < messages.length; i++) {
            for (int j = 0; j < messages[i].length(); j++) {
                if (j == 0) {
                    decodeMessage += Character.toString(messages[i].charAt(j)).toLowerCase();
                } else {
                    decodeMessage += Character.toString(messages[i].charAt(j)).toUpperCase();
                }
            }
            decodeMessage += " ";
        }
        bufferedWriter.write(decodeMessage.strip());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
