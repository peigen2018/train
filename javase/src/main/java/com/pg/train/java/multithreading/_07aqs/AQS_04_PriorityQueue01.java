package com.pg.train.java.multithreading._07aqs;


import com.pg.train.java.multithreading.ThreadUtils;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.ArrayBlockingQueue;

public class AQS_04_PriorityQueue01 {
    static PriorityQueue<String> queue = new PriorityQueue<>(10, new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return Integer.compare(o1.length(), o2.length());
        }
    });


    public static void main(String[] args) {

        queue.add("a");
        queue.add("abaaa");
        queue.add("acc");
        queue.add("ac");

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
