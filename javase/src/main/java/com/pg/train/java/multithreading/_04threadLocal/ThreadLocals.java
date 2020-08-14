package com.pg.train.java.multithreading._04threadLocal;

import com.pg.train.java.multithreading.ThreadUtils;

public class ThreadLocals {
    private static final ThreadLocal<Long> Time_ThreadLocal = new ThreadLocal<Long>() {
        @Override
        protected Long initialValue() {
            long l = System.currentTimeMillis();
            ThreadUtils.print(Thread.currentThread(), "init", l);
            return l;
        }
    };

    private static final void begin() {
        long value = System.currentTimeMillis();
        ThreadUtils.print(Thread.currentThread(), "begin", value);
        Time_ThreadLocal.set(value);
    }

    ;


    private static final long end() {
        long value = System.currentTimeMillis() - Time_ThreadLocal.get();
        ThreadUtils.print(Thread.currentThread(), "end", value);
        return value;
    }

    public static void main(String[] args) {

        begin();
        ThreadUtils.sleep(100);
        System.out.println(end());

        Thread t = new Thread(() -> {
            begin();
            ThreadUtils.sleep(200);
            System.out.println(end());
        });

        t.start();
    }

}
