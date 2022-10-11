package me.day13.thread.basics;

public class ThreadExample {
    public static void main(String[] args) {
        System.out.println("\n==========================================================");
        System.out.println("\t\t1. Thread 클래스를 상속받은 MyThread 클래스 객체 생성");
        System.out.println("==========================================================");
        Thread myThread1 = new MyThread("myThread1");
        Thread myThread2 = new MyThread("myThread2");
        myThread1.start();
        myThread2.start();

        try {
            Thread.sleep(10000); // 메인 스레드 10초 sleep()
        } catch(InterruptedException e) {
            System.out.println(e);
        }


        System.out.println("\n==========================================================");
        System.out.println("\t\t2. MyRunnable 객체를 인자로 전달하여 Thread 생성");
        System.out.println("==========================================================");
        Thread myRunnable1 = new Thread(new MyRunnable("myRunnable1"));
        Thread myRunnable2 = new Thread(new MyRunnable("myRunnable2"));
        myRunnable1.start();
        myRunnable2.start();

        try {
            Thread.sleep(10000); // 메인 스레드 10초 sleep()
        } catch(InterruptedException e) {
            System.out.println(e);
        }


        System.out.println("\n==========================================================");
        System.out.println("\t\t3. Runnable 익명 객체를 인자로 전달하여 Thread 생성");
        System.out.println("==========================================================");
        Thread anonymous1 = new Thread(new Runnable() {
            private static final int ITERATIONS = 10;
            private String name = "anonymous1";


            @Override
            public void run() {
                for (int i = 0; i < ITERATIONS; i++) {
                    System.out.println(name + " => " + i);
                }

            }
        });


        Thread anonymous2 = new Thread(new Runnable() {
            private static final int ITERATIONS = 10;
            private String name = "anonymous2";


            @Override
            public void run() {
                for (int i = 0; i < ITERATIONS; i++) {
                    System.out.println(name + " => " + i);
                }

            }
        });
        anonymous1.start();
        anonymous2.start();


    }
}
