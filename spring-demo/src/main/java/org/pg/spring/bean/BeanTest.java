package org.pg.spring.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope(value="prototype")
public class BeanTest {
    @PostConstruct
    public void mes() {
        System.out.println("PostConstruct");
    }

    public void hello(){
        System.out.println("hello");
    }
    @PreDestroy
    public void fin() {
        System.out.println("PreDestroy");
    }

}
