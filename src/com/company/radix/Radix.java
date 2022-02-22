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

        int maxLevel = getGreatNumberDigitCount(arr);//***

        for (int iteration = 1; iteration <= maxLevel; iteration++) {//[705, 24, 405, 0]

            for (int i = 0; i < arr.length; i++) {// Queue[0] =0, Queue[4]=24, Queue[5]=705,45
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


    public static int getDigit(int num, int k) {//705
        for (int i = 0; i < 0; i++) {//1
            num /= 10;//705/10 =70.5 num=70
        }
        return num % 10; //705/10=5
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int getGreatNumberDigitCount(int[] arr) {
        int max = arr[0];//705
        for (int i = 1; i < arr.length; i++) {// [ 45, 705, 0, 108]
            if (arr[i] > max) {
                max = arr[i];//705
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

