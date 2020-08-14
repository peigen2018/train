package com.pg.demo.algorithm.search;

public class MoveSearch {
    public static boolean Find(int target, int[][] array) {

        int row = 0;
        int column = array.length - 1;

        while (row < array[0].length && column >= 0) {
            System.out.println("row:"+row+ "column:"+ column);
            if (array[column][row] == target) {
                return true;
            }
            if (array[column][row] < target) {
                row++;
                continue;
            }
            if (array[column][row] > target) {
                column--;
                continue;
            }
        }
        return false;
    }


    public static void main(String[] args) {


        int[][] arr3 = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(Find(16, arr3));
    }
}
