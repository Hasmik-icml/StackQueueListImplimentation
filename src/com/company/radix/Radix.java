package com.company.radix;
import com.company.collections.Queue;
import java.util.Arrays;

import java.util.Random;
import java.util.Stack;

public class Radix {
    public static void main(String[] args) {

        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(1000);
        }
        printArray(arr);


//        Queue<Integer>[] order = new Queue[10];
        Queue<Integer>[] order = new Queue[10];
        for (int i = 0; i < order.length; i++) {
            order[i] = new Queue<>();
        }

        int maxLevel = getGreatNumberDigitCount(arr);

        for (int iteration = 1; iteration <= maxLevel; iteration++) {

            for (int i = 0; i < arr.length; i++) {
                order[getDigit(arr[i], iteration)].push(arr[i]);
            }

            int tempIndex = 0;
            for (int i = 0; i < order.length; i++) {
                while (!order[i].isEmpty()) {
                    arr[tempIndex++] = order[i].front();
                    order[i].pop();
                }
            }
            printArray(arr);

        }



    }


    public static int getDigit(int num, int k) {
        for (int i = 0; i < k - 1; i++) {
            num /= 10;
        }
        return num % 10;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int getGreatNumberDigitCount(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int count = 0;
        while (max != 0) {
            count++;
            max /= 10;
        }

        return count;
    }


}

