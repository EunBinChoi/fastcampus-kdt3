package me.day04.loop;

public class NestedLoopBreakExample2 {
    public static void main(String[] args) {
        printPairOfAlphabet();
    }
    public static void printPairOfAlphabet() {
        for (char upper = 'A'; upper <= 'Z'; upper++) {
            for (char lower = 'a'; lower <= 'z'; lower++) {
                System.out.printf("%c - %c\n", upper, lower);
                if (lower == 'g') {
                    return;
                }
            }
        }
    }
}
