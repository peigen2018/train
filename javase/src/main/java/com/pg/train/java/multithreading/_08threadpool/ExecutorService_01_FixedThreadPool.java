package com.pg.train.java.multithreading._08threadpool;

import com.pg.train.java.multithreading.ThreadUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorService_01_FixedThreadPool {
    static ExecutorService executorService = Executors.newFixedThreadPool(4);

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            final int j = i;
           executorService.submit(()->{
               ThreadUtils.sleep(1000);
               ThreadUtils.print(Thread.currentThread(),j);
           });

        }
    }
}
