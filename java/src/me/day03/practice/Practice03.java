package me.day03.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice03 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String equation = bufferedReader.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(equation);

        int num1 = Integer.parseInt(stringTokenizer.nextToken());
        char op = stringTokenizer.nextToken().charAt(0);
        int num2 = Integer.parseInt(stringTokenizer.nextToken());


        if (op == '+') {
            System.out.printf("%d %c %d = %d\n", num1, op, num2,  num1 + num2);
        } else if (op == '-') {
            System.out.printf("%d %c %d = %d\n", num1, op, num2,  num1 - num2);
        } else if (op == '*') {
            System.out.printf("%d %c %d = %d\n", num1, op, num2,  num1 * num2);
        } else if (op == '/') {
            System.out.printf("%d %c %d = %f\n", num1, op, num2,  (double)num1 / num2);
        } else if (op == '%') {
            System.out.printf("%d %c %d = %d\n", num1, op, num2,  num1 % num2);
        } else {
            System.out.println("not valid operator.");
        }

        bufferedReader.close();
    }
}
