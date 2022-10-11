package me.day13.thread.basics;

public class ThreadExample {
    public static void main(String[] args) {
        /**
         * [ 스레드 (thread) ]
         *
         * - 멀티 태스킹 (Multi-tasking)
         * : 여러 개 앱을 동시에 실행
         *
         * - 프로그램 (Program) vs 프로세스 (Process)
         * : 프로그램: 실행할 수 있는 파일이나 앱
         * : 프로세스: 메모리를 차지하면서 연속적으로 실행되고 있는 프로그램
         *
         * - 코어 (Core)
         * : 멀티 태스킹을 가능하게 하는 작업자 (물리적인 단위)
         *
         * - 스레드 (Thread)
         * : 코어를 인식하는 논리적인 단위
         * : 각 프로세스는 최소 1개의 스레드를 가짐
         *
         * ex) 코어: 6개, 스레드: 12개
         * => 실제 작업자는 6명인데 컴퓨터한테는 12명인 것처럼 속임
         * (hyper threading, 하이퍼 스레딩)
         *
         * - 다중 스레딩 (Multi-threading)
         * : 하나의 프로그램이 여러 스레드에 할당받아 일을 하는 것
         * ex) 워드 프로그램 -> 문서 편집, 인쇄
         * */

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
