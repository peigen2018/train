package com.pg.train.java.multithreading.syn;

public class Subduction {
    private int num = 1000;

    public  int sub() {
        int t = num -1;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        num = t;
        return num;
    }

    public int getNum() {
        return num;
    }
}
