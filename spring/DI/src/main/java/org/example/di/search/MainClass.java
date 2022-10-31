package org.example.di.search;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

    public static void main(String[] args) {
        // 등록된 스프링 컨테이너 검색
        AnnotationConfigApplicationContext ctx  = new AnnotationConfigApplicationContext(Transportation.class);

        // Transportation transportation = new Transportation()
        Transportation transportation1 = ctx.getBean("transportation",  Transportation.class);

        transportation1.move();
        System.out.println(transportation1);
        System.out.println(ctx.isSingleton("transportation"));
        System.out.println();


        Transportation transportation2 = ctx.getBean("transportation", Transportation.class);

        transportation2.move();
        System.out.println(transportation2);
        System.out.println(ctx.isSingleton("transportation"));
        System.out.println();

        System.out.println("address: " + (transportation1 == transportation2));

        ctx.close();

    }

}