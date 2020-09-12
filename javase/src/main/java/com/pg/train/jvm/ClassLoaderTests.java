package com.pg.train.jvm;

public class ClassLoaderTests {
    public static void main(String[] args) throws ClassNotFoundException {

        String s = new String();
        System.out.println(s.getClass().getClassLoader());


        ClassLoaderTests c = new ClassLoaderTests();
        System.out.println(c.getClass().getClassLoader().loadClass(""));
    }
}
