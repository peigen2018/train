package com.pg.train.java.multithreading.syn;

import java.util.concurrent.CountDownLatch;

public class ThreadSub extends Thread {

    private Subduction sub;

    private CountDownLatch cc;

    public ThreadSub(Subduction sub, CountDownLatch cc) {

        this.sub = sub;
        this.cc = cc;
        cc.countDown();
    }

    @Override
    public void run() {

        try {
            cc.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(this.getName() + ": " + sub.sub());
    }
}
