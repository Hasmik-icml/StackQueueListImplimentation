package com.company.fibonachi;

public class fibonachi {
    public static int counter = 0;
    public static void main(String[] args) {

        int val = 8;
//        System.out.println(fib_iter(val));
        System.out.println(fib_rec(val));
        int[] arr = new int[val];
        initArr(arr);
//        System.out.println(fib_rec_arr(val, arr));
        System.out.println("counter: "+ counter);
    }


    public static int fib_iter(int n) {
        int f = 1;
        int s = 1;
        int t = 0;


        for (int i = 3; i <= n; i++) {
            t = f + s;
            f = s;
            s = t;
        }
        return t;
    }

    public static int fib_rec(int n) {
        counter++;
        if (n < 3) {
            return 1;
        }
        return fib_rec(n - 2) + fib_rec(n - 1);
    }


    public static int fib_rec_arr(int n, int[] arr) {
        counter++;
        if (arr[n - 1] == -1) {
            arr[n - 1] = fib_rec_arr(n - 2, arr) + fib_rec_arr(n - 1, arr);
        }
        return arr[n - 1];
    }


    private static void initArr(int[] arr) {

        arr[0] = arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = -1;
        }
    }
}