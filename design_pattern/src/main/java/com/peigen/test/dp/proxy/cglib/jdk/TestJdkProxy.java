package com.peigen.test.dp.proxy.cglib.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class TestJdkProxy {
    public static void main(String[] args) {
        MyInf inf = new MyInf() {
            @Override
            public String hello() {
                return "hello world";
            }
        };


        InvocationHandler handler = new MyProxy(inf);


        MyInf proxyHello = (MyInf) Proxy.newProxyInstance(inf.getClass().getClassLoader(), inf.getClass().getInterfaces(), handler);

        System.out.println(proxyHello.hello());
    }
}
