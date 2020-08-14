package com.pg.train.java.multithreading._07aqs;


import com.pg.train.java.multithreading.ThreadUtils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AQS_03_BlockingQueue01 {
    static ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(1000, false);


    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            ThreadUtils.sleep(1000);
            new Thread(()->{
                while (true){
                    ThreadUtils.sleep(1000);
                    queue.add("abo");
                    ThreadUtils.print(Thread.currentThread(),queue.size(),queue.toString());
                }
            },"proctor" + i).start();
        }

        for (int i = 0; i < 5; i++) {
            ThreadUtils.sleep(1000);
            new Thread(()->{
                while (true){
                    ThreadUtils.sleep(1000);
                    queue.poll();

                    ThreadUtils.print(Thread.currentThread(),queue.size(),queue.toString());
                }
            },"customer" + i).start();
        }
    }
}
