package com.pg.train.java.multithreading._07aqs;


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class AQS_05_DelayQueue01 {
    static DelayQueue<DelayObj> queue;


    public static void main(String[] args) {

    }

    static class DelayObj implements Delayed{

        @Override
        public long getDelay(TimeUnit unit) {
            return 0;
        }

        @Override
        public int compareTo(Delayed o) {
            return 0;
        }
    }
}
