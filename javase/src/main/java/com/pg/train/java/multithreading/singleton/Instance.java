package com.pg.train.java.multithreading.singleton;

public class Instance {
    private volatile static Instance dabbleCheck;

    public static Instance getInstance() {
        if (dabbleCheck == null) {
            synchronized (Instance.class) {
                if (dabbleCheck == null) {

                    dabbleCheck = new Instance();
                }
            }
        }
        return dabbleCheck;
    }

}
