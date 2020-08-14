package com.pg.train.java.multithreading._07aqs;


import com.pg.train.java.multithreading.ThreadUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.concurrent.*;

public class AQS_08_CountDownLatch {
    static CountDownLatch c = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            ThreadUtils.print(Thread.currentThread(),"----------1 start----------");

            c.countDown();

            ThreadUtils.print(Thread.currentThread(),"----------1 end----------");
        });


        Thread t2 = new Thread(()->{
            ThreadUtils.print(Thread.currentThread(),"----------2 start----------");
            c.countDown();
            try {
                c.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ThreadUtils.print(Thread.currentThread(),"----------2 end----------");
        });

        t.start();
        ThreadUtils.sleep(1000);
        t2.start();
        c.await();
    }
}
