package com.pg.train.java.multithreading._08threadpool;

import com.pg.train.java.multithreading.ThreadUtils;

import java.util.concurrent.*;

public class ExecutorService_04_ScheduledFutureTask {
    static ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        for (int i = 0; i < 3; i++) {
            final int j = i;
            ScheduledFuture<?> schedule = executorService.schedule(() -> {
                ThreadUtils.print(Thread.currentThread(), j);
                return j;
            }, i+2, TimeUnit.SECONDS);

            Object o = schedule.get();
            System.out.println(o);
        }
    }
}
