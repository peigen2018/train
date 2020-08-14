package com.peigen.test.base;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassLoaderSample extends ClassLoader {

    private String path;

    public ClassLoaderSample(String path) {
        this.path = path;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] bytes = loadClassFile(name);
        return super.defineClass(name, bytes, 0, bytes.length);
    }

    private byte[] loadClassFile(String name) {

        try (InputStream is = new FileInputStream(path + name + ".class");
             ByteArrayOutputStream os = new ByteArrayOutputStream()) {

            int i = 0;
            while ((i = is.read()) != -1) {
                os.write(i);
            }


            return os.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) throws Exception {

        ClassLoaderSample loaderSample = new ClassLoaderSample("/home/peigen/Desktop/");

        Class refectSampleClass =  loaderSample.loadClass("RefectSample");

        Object refectSample = refectSampleClass.newInstance();

        Field name = refectSampleClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(refectSample,"success");

        Method getName = refectSampleClass.getDeclaredMethod("getName");


        System.out.println(getName.invoke(refectSample));

    }
}
