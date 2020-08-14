package com.pg.demo.algorithm.print;

import java.util.Scanner;

public class PrintMain {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            int countText = n / 2 + i;
            if (countText > n) {
                countText = 2 * n - countText;
            }

            int spaceNum = n - countText;
            StringBuilder text = new StringBuilder();
            for (int j = 0; j < countText; j++) {
                if (j < spaceNum) {
                    text.append(" ");
                } else {
                    text.append("*");
                }
            }

            System.out.println(text);
        }

    }
}
