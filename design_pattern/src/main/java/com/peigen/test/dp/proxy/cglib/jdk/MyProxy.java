package com.peigen.test.dp.proxy.cglib.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyProxy implements InvocationHandler {
    final private MyInf obj;

    public MyProxy(MyInf obj) {
        this.obj = obj;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object invoke = method.invoke(obj, args);
        System.out.println("after");

        return invoke;
    }
}
