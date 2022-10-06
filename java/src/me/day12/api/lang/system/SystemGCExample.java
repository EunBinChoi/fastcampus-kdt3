package me.day12.api.lang.system;

public class SystemGCExample {
    public static void main(String[] args) {
        Student student = null;

        // Profiler
        // G1CalculatePointersClosure
        for (int i = 0; i < 10; i++) {
            student = new Student(i + 'a' + "");
        }
        System.gc();
    }
}
