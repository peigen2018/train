package com.pg.train.java.multithreading.method;

import com.pg.train.java.multithreading.ThreadUtils;

public class ThreadJoin extends Thread {

    private Thread other;

    public ThreadJoin(Thread other,String name) {
        this.other = other;
        this.setName(name);
    }

    @Override
    public void run() {

        try {
            other.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ThreadUtils.print(this);
    }

}
