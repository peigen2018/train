package com.pg.train.java.multithreading._07aqs;


import com.pg.train.java.multithreading.ThreadUtils;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class AQS_10_Semaphore {
    static Semaphore s = new Semaphore(4);

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {

        for (int i = 0; i < 20; i++) {
            Thread t = new Thread(() -> {
                try {
                    s.acquire();
                    ThreadUtils.print(Thread.currentThread(), "----------start----------");
                    ThreadUtils.sleep(5000);
                    ThreadUtils.print(Thread.currentThread(), "----------end----------");
                    s.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "thread" + i);
            t.start();
        }
    }
}
