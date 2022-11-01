package org.example.overview.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class LifeCycle implements InitializingBean, DisposableBean, BeanNameAware, ApplicationContextAware {

    private AnotherLifeCycle anotherLifeCycle;

    @Override
    public void setBeanName(String name) {
        System.out.println("BeanNameAware " + name);
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContextAware " + applicationContext);
    }


    @Autowired
    public LifeCycle(AnotherLifeCycle anotherLifeCycle) {
        this.anotherLifeCycle = anotherLifeCycle;
        System.out.println("LifeCycle(AnotherLifeCycle anotherLifeCycle)");
    }

    ////////////////////////////////////////////////////////////////////////
    // 빈 생성 메소드
    @PostConstruct
    public void postConstruct() {
        System.out.println(this.getClass().getName() + " postConstruct()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(this.getClass().getName() + " afterPropertiesSet()");
    }

    public void initMethod() {
        System.out.println(this.getClass().getName() + " initMethod()");
    }

    ////////////////////////////////////////////////////////////////////////
    // 빈 소멸 메소드

    @PreDestroy
    public void preDestory() {
        System.out.println(this.getClass().getName() + " preDestory()");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println(this.getClass().getName() + " destroy()");
    }

    public void destroyMethod() {
        System.out.println(this.getClass().getName() + " destroyMethod()");
    }


}
