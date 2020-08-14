package com.pg.train.java.multithreading._02daemon;

import com.pg.train.java.multithreading.ThreadUtils;

public class Daemon {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            ThreadUtils.sleep(100);
            System.out.println("over");
        });

        //when set daemon = true the thread  can not print 'over'
        t.setDaemon(true);
        t.start();


    }
}
