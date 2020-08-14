package com.pg.demo.algorithm.search;

public class BinarySearch {
    public static boolean Find(int target, int[][] array) {

        if (array == null || array.length == 0) {
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i]==null || array[i].length==0){
                return false;
            }
            if (array[i][0] == target) {
                return true;
            }
            if (array[i][0] < target) {
                if (binarySearch(target, array[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean binarySearch(int target, int[] array) {

        int low = 0;
        int high = array.length - 1;

        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;

            if (array[mid] == target) {
                System.out.println("index:" + mid);
                System.out.println("value:" + array[mid]);
                return true;
            } else if (array[mid] > target) {
                high = mid - 1;
            } else if (array[mid] < target) {
                low = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {


        int[][] arr3 = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        int[][] array = {{}};
        System.out.println(Find(8, arr3));
    }
}
