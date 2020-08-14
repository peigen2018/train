package com.pg.train.java.multithreading.singleton;

public class InnerClass {
    public static class InstanceHolder {
        public static Instance instance = new Instance();
    }

    public Instance getInstance() {
        return InstanceHolder.instance;
    }
}
