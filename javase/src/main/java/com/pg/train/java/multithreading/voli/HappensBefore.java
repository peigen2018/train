package com.pg.train.java.multithreading.voli;

public class HappensBefore {
    public static volatile int num = 1;

    public static void main(String[] args) throws Exception {

        Thread b = new Thread(() -> {

            System.out.println(num);
        });

        b.start();


        num = 2;


    }
}
