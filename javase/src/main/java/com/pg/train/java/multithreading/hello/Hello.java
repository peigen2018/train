package com.pg.train.java.multithreading.hello;

public class Hello implements Runnable {
    public static void main(String[] args) {

        Runnable r = new Hello();


        new Thread(r).start();

        new ThreadHello().start();
        System.out.println("next");
    }

    @Override
    public void run() {
        System.out.println("hellowWorld");
    }

    public static class ThreadHello extends Thread {
        @Override
        public void run() {
            System.out.println("hellowWorld thread");
        }
    }
}
