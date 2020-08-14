package com.pg.train.java.multithreading._07aqs;


import com.pg.train.java.multithreading.ThreadUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.*;

public class AQS_07_ForkJoin01 {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool pool = new ForkJoinPool();

        ForkJoinTask<Integer[]> submit = pool.submit(new SortTask(new Integer[]{20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8}));
        Integer[] integers = submit.get();
        System.out.println(ArrayUtils.toString(integers));
    }

    static class SortTask extends RecursiveTask<Integer[]> {

        private Integer[] arr;

        public SortTask(Integer[] arr) {
            this.arr = arr;
        }

        private Integer[] marge(Integer[] arr1, Integer[] arr2) {

            Integer[] integers = ArrayUtils.addAll(arr1, arr2);
            ThreadUtils.print(Thread.currentThread(),Arrays.toString(integers));
            Arrays.sort(integers);
            return integers;
        }

        @Override
        protected Integer[] compute() {
            if (arr.length < 4) {
                Arrays.sort(arr);
                return arr;
            } else {
                int end = arr.length / 2;
                Integer[] subarray = ArrayUtils.subarray(arr, 0, end);
                Integer[] subarray2 = ArrayUtils.subarray(arr, end, arr.length);

                SortTask leftTask = new SortTask(subarray);
                SortTask rightTask = new SortTask(subarray2);
                leftTask.fork();
                rightTask.fork();
                Integer[] join1 = leftTask.join();
                Integer[] join2 = rightTask.join();

                return this.marge(join1,join2);
            }
        }
    }
}
