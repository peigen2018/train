package com.pg.train.java.multithreading.syn;

import com.pg.train.java.multithreading.ThreadUtils;

import java.util.Arrays;

public class NotifyWait {
    public static final Object lock = new Object();


    static class RunnableA implements Runnable {
        char[] val;

        public RunnableA() {
            val = new char[26];
            int t = 0;
            for (char i = 65; i < 65 + val.length; i++) {
                val[t++] = i;
            }
        }

        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < val.length; i++) {
                    System.out.print(val[i]);
                    try {
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }
                lock.notifyAll();
            }
        }
    }

    static class RunnableB implements Runnable {
        int[] val;

        public RunnableB() {
            val = new int[26];
            for (int i = 0; i < val.length; i++) {
                val[i] = i + 1;
            }
        }

        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < val.length; i++) {
                    System.out.println(val[i]);
                    try {
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new RunnableA());
        Thread t2 = new Thread(new RunnableB());

        t1.start();
        ThreadUtils.sleep(10);
        t2.start();
    }
}
