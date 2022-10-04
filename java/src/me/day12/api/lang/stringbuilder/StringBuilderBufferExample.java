package me.day12.api.lang.stringbuilder;

public class StringBuilderBufferExample {
    public static void main(String[] args) {
        // 현재 코드로 profile 해보기
        // StringBuilder vs StringBuffer 비교
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                StringBuilder stringBuilder = new StringBuilder("abc");
                for (int i = 0; i < 100000000; i++) {
                    stringBuilder.append(" abc");
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                StringBuffer stringBuffer = new StringBuffer("abc");
                for (int i = 0; i < 100000000; i++) {
                    stringBuffer.append(" abc");
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
