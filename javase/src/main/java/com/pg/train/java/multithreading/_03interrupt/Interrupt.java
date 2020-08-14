package com.pg.train.java.multithreading._03interrupt;

import com.pg.train.java.multithreading.ThreadUtils;

public class Interrupt {
    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            while (true) {
            }
        });

        Thread b = new Thread(() -> {
            while (true) {
                ThreadUtils.sleep(100);
            }
        });

        a.start();
        b.start();
        ThreadUtils.sleep(100);

        a.interrupt();
        b.interrupt();

        ThreadUtils.print(a, a.isInterrupted());
        ThreadUtils.print(b, b.isInterrupted());
        ThreadUtils.sleep(100);
    }
}
