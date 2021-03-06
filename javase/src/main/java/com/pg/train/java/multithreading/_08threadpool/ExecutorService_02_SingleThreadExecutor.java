package com.pg.train.java.multithreading._08threadpool;

import com.pg.train.java.multithreading.ThreadUtils;
import sun.applet.AppletClassLoader;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorService_02_SingleThreadExecutor {
    static ExecutorService executorService = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            final int j = i;
           executorService.submit(()->{
               ThreadUtils.sleep(1000);
               ThreadUtils.print(Thread.currentThread(), j);
           });
        }
    }
}
