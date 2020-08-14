package com.pg.train.java.multithreading.syn;

import java.util.concurrent.CountDownLatch;

public class TestMain {
    public static void main(String[] args) {
        Subduction sub = new Subduction();

        CountDownLatch cc = new CountDownLatch(1000);

        for (int i = 0; i < 1000; i++) {
            ThreadSub sub1 = new ThreadSub(sub,cc);
            sub1.start();
        }


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(sub.getNum());

    }
}
