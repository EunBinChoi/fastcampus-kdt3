package me.day03.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice04 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String nums = bufferedReader.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(nums, ", ");
        double x = Double.parseDouble(stringTokenizer.nextToken());
        double y = Double.parseDouble(stringTokenizer.nextToken());

        if (x == 0 && y == 0) {
            System.out.println("origin point.");
        } else if (x == 0) {
            System.out.println("on the y axis.");
        } else if (y == 0) {
            System.out.println("on the x axis.");
        } else if (x > 0 && y > 0) {
            System.out.println("the 1 quadrant.");
        } else if (x < 0 && y > 0) {
            System.out.println("the 2 quadrant.");
        } else if (x < 0 && y < 0) {
            System.out.println("the 3 quadrant.");
        } else if (x > 0 && y < 0) {
            System.out.println("the 4 quadrant.");
        }

        bufferedReader.close();
    }
}
