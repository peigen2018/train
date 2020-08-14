package com.peigen.test.base;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class RefectSample {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) throws Exception {
        Class<RefectSample> aClass = (Class<RefectSample>) Class.forName("com.peigen.test.base.RefectSample");

        RefectSample refectSample = aClass.newInstance();

        refectSample.setName("abc");
        System.out.println(refectSample.getName());

        Method getName = aClass.getDeclaredMethod("getName");

        System.out.println(getName.invoke(refectSample));

        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(refectSample,"def");

        System.out.println(name.get(refectSample));
        System.out.println(getName.invoke(refectSample));

    }
}
