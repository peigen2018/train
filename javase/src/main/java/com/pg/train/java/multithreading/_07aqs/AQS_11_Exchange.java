package com.pg.train.java.multithreading._07aqs;


import com.pg.train.java.multithreading.ThreadUtils;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Exchanger;
import java.util.concurrent.Semaphore;

public class AQS_11_Exchange {
    static Exchanger e = new Exchanger();

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {

        new Thread(() -> {
            String a="helllo t1";

            try {
                Object exchange = e.exchange(a);
                ThreadUtils.print(Thread.currentThread(),exchange);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }, "t1").start();

        new Thread(() -> {
            String a="helllo t2";

            try {
                Object exchange = e.exchange(a);
                ThreadUtils.print(Thread.currentThread(),exchange);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }, "t2").start();

    }
}
