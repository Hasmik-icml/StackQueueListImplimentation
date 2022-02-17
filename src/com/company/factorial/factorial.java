package com.company.factorial;

public class factorial {
    public static double factorial_rec(double n){
        if (n < 1) return 1;
        return n * factorial_rec(n - 1);
    }

    public  static  double factorial_iter(double n){
        double f = 1;
       for (int i = 1; i <= n; i++){
           f *= i;
       }
       return f;
    }
    public static void main(String[] args){

        System.out.println(factorial_rec(5));
        System.out.println(factorial_iter(5));

    }
}
