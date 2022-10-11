package me.day13.thread.basics;

public class MyThread extends Thread {
    private static final int ITERATIONS = 10;
    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < ITERATIONS; i++) {
            System.out.println(name + " => " + i);
        }
    }

    @Override
    public String toString() {
        return "MyThread{" +
                "name='" + name + '\'' +
                '}';
    }
}
