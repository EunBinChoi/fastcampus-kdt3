package org.example.overview.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class AnotherLifeCycle implements InitializingBean, DisposableBean {

    public AnotherLifeCycle() {
        System.out.println("AnotherLifeCycle()");
    }

    //////////////////////////////////////////////
    // 빈 생성 메소드
    @PostConstruct
    public void postConstruct() {
        System.out.println(this.getClass().getName() + " postConstruct()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(this.getClass().getName() + " afterPropertiesSet()");
    }

    public void anotherInitMethod() {
        System.out.println(this.getClass().getName() + " initMethod()");
    }

    //////////////////////////////////////////////
    // 빈 소멸 메소드

    @PreDestroy
    public void preDestory() {
        System.out.println(this.getClass().getName() + " preDestory()");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println(this.getClass().getName() + " destroy()");
    }

    public void anotherDestroyMethod() {
        System.out.println(this.getClass().getName() + " destroyMethod()");
    }
}
