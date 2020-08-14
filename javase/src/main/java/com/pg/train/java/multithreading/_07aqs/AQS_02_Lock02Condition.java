package com.pg.train.java.multithreading._07aqs;


import com.pg.train.java.multithreading.ThreadUtils;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AQS_02_Lock02Condition {
    static Lock lock = new ReentrantLock(true);

    static Condition condition1 = lock.newCondition();


    public static void main(String[] args) throws InterruptedException {


        Thread a = new Thread(() -> {

            lock.lock();
            System.out.println("hii---------");
            try {
                condition1.await();

                System.out.println("hoooo---------");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        a.start();

        ThreadUtils.sleep(2000);
        lock.lock();
        ThreadUtils.sleep(2000);
        System.out.println("signal....");
        condition1.signal();
        ThreadUtils.sleep(2000);
        lock.unlock();
    }
}
