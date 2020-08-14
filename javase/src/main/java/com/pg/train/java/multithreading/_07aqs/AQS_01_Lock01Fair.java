package com.pg.train.java.multithreading._07aqs;


import com.pg.train.java.multithreading.ThreadUtils;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AQS_01_Lock01Fair {
    static Lock lock = new ReentrantLock(true);

    public static void main(String[] args) {


        Thread a = new Thread(() -> {

            while (true) {
                lock.lock();
                try {
                    ThreadUtils.sleep(1000);
                    ThreadUtils.print(Thread.currentThread());
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread b = new Thread(() -> {

            while (true) {
                lock.lock();
                try {
                    ThreadUtils.sleep(1000);
                    ThreadUtils.print(Thread.currentThread());
                } finally {
                    lock.unlock();
                }
            }
        });

        a.start();
        b.start();

    }
}
