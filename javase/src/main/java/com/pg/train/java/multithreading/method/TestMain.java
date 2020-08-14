package com.pg.train.java.multithreading.method;

public class TestMain {
    public static void main(String[] args) throws InterruptedException {
        Thread preThread = Thread.currentThread();

        for (int i = 0; i < 10; i++) {
            Thread thread = new ThreadJoin(preThread, "t" + i);
            thread.start();
            preThread = thread;
        }


    }
}
