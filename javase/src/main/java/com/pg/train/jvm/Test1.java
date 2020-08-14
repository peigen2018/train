package com.pg.train.jvm;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test1 {

    //1. 区分概念：内存泄漏memory leak，内存溢出out of memory
    //2. java -XX:+PrintCommandLineFlags HelloGC
    //3. java -Xmn10M -Xms40M -Xmx60M -XX:+PrintCommandLineFlags -XX:+PrintGC  HelloGC
    //    PrintGCDetails PrintGCTimeStamps PrintGCCauses
    //4. java -XX:+UseConcMarkSweepGC -XX:+PrintCommandLineFlags HelloGC
    //5. java -XX:+PrintFlagsInitial 默认参数值
    //6. java -XX:+PrintFlagsFinal 最终参数值
    //7. java -XX:+PrintFlagsFinal | grep xxx 找到对应的参数
    //8. java -XX:+PrintFlagsFinal -version |grep GC
    public static void main(String[] args) {
        System.out.println("HelloGC!");
        List list = new LinkedList();
        for (; ; ) {
            byte[] b = new byte[1024 * 1024];
            list.add(b);
        }

    }
}
