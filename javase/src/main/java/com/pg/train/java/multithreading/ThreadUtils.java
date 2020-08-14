package com.pg.train.java.multithreading;

import java.util.Arrays;

public class ThreadUtils {
    public static void print(Thread t, Object... o) {
        System.out.println(t.getName() + " : " + t.getState() + " data" + Arrays.toString(o));
    }

    public static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
