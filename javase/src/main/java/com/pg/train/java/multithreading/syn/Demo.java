package com.pg.train.java.multithreading.syn;

public class Demo {
    public static void main(String[] args) {
        synchronized (Demo.class) {

        }
        m();
    }

    public synchronized static void m() {

    }
}
