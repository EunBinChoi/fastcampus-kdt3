package me.day04.loop;

public class InfiniteLoopExample {
    public static void main(String[] args) {
//        while(true) {
//            System.out.println("infinite loop");
//        }
//
//        for(;;) {
//            System.out.println("infinite loop");
//        }

        ////////////////////////////////////////////////////
        // 반복문의 증감문이 없어도 무한루프
        ///////////////////////////////////////////////////

        int i = 0;
        while(i < 10) {
            System.out.println("infinite loop");
            // 증감식
        }
//
//        for (int j = 0; j < 10; /*증감식*/ ) {
//            System.out.println("infinite loop");
//
//        }

    }
}
