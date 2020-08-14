package com.pg.train.java.multithreading._07aqs;


import com.pg.train.java.multithreading.ThreadUtils;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class AQS_06_SynchronousQueue01 {
    static SynchronousQueue<String> queue = new SynchronousQueue<>();

    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                ThreadUtils.sleep(1000);
                try {
                    queue.put("bcc");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                ThreadUtils.print(Thread.currentThread(),queue.toString());
            }
        }, "proctor").start();


        new Thread(() -> {
            while (true) {
                ThreadUtils.sleep(2000);
                try {
                    ThreadUtils.print(Thread.currentThread(),queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "customer").start();


    }

}
