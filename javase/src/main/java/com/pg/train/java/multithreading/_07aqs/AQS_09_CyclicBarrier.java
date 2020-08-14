package com.pg.train.java.multithreading._07aqs;


import com.pg.train.java.multithreading.ThreadUtils;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class AQS_09_CyclicBarrier {
    static CyclicBarrier c = new CyclicBarrier(2);

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        Thread t = new Thread(()->{
            ThreadUtils.print(Thread.currentThread(),"----------1 start----------");

            try {
                c.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

            ThreadUtils.print(Thread.currentThread(),"----------1 end----------");
        });


        Thread t2 = new Thread(()->{
            ThreadUtils.print(Thread.currentThread(),"----------2 start----------");
            ThreadUtils.print(Thread.currentThread(),"sleep");

            ThreadUtils.sleep(1000);

            try {
                c.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

            ThreadUtils.print(Thread.currentThread(),"----------2 end----------");
        });

        t.start();
        ThreadUtils.sleep(1000);
        t2.start();
    }
}
