package org.pg.spring;

import org.pg.spring.bean.BeanTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrainspringApplication {

    public static void main(String[] args) throws InterruptedException {

        BeanTest bean = SpringApplication.run(TrainspringApplication.class, args).getBean(BeanTest.class);

        bean.hello();

        Thread.sleep(10000);
    }

}
