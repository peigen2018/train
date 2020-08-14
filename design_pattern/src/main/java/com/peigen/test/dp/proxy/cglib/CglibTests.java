package com.peigen.test.dp.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;
import net.sf.cglib.proxy.MethodInterceptor;

public class CglibTests {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallback((MethodInterceptor) (obj, method, arg, proxy) -> {
            if (method.getDeclaringClass() != Object.class && method.getReturnType() == String.class) {
                return "Hello Tom!";
            } else {
                return proxy.invokeSuper(obj, arg);
            }
        });
        UserService proxy = (UserService) enhancer.create();

        String res = proxy.userId();
        System.out.println(res);
        System.out.println(proxy.age());
    }

}
