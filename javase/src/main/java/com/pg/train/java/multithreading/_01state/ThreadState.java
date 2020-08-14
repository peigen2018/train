package com.pg.train.java.multithreading._01state;

import com.pg.train.java.multithreading.ThreadUtils;

public class ThreadState {
    static class Running implements Runnable {

        @Override
        public void run() {
            synchronized (Running.class) {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class Waiting implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (Waiting.class) {
                    try {
                        Waiting.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }

    static class TimeWaiting implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("running -------------------");
        Thread runningA = new Thread(new Running());
        Thread runningB = new Thread(new Running());
        ThreadUtils.print(runningA);
        ThreadUtils.print(runningB);

        runningA.start();
        runningB.start();
        ThreadUtils.print(runningA);
        ThreadUtils.print(runningB);

        //jps
        //jstack pid
        System.out.println("running and block   -------------------");

        System.out.println("wait-------------------");


        Thread runningc = new Thread(new Waiting());
        runningc.start();
        ThreadUtils.sleep(1000);
        ThreadUtils.print(runningc);
        System.out.println("wait-------------------");


    }
}
