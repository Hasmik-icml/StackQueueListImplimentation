package com.company;
import com.company.collections.Queue;
import com.company.collections.List;
import com.company.collections.collectionsUtil.Node;


import java.lang.reflect.Type;
import java.util.*;


public class Main {
//public static int fibonacciRecursion(int n){
//    int f = 1;
//    int s = 1;
//    int t = 2;
//    if (n < 1) return  -1;
//    if (n < 3) return  1;
////    for (int i = 3; i <= n; i++){
////        t = f + s;
////        f  = s;
////        s = t;
////    }
////    return fibonacciRecursion(n - 2) + fibonacciRecursion(n - 1);
//}
    public static void main(String[] args) {
//        System.out.println(fibonacciRecursion(13));
//        List<Integer> list = new List<>();
//        list.push(5);//0
//        list.push(8);//1
//        list.push(83);//2
//        list.remove(1);
//
//        System.out.println(list);
//        System.out.println(list.getFirst().getInfo());
//        System.out.println(list.getLast());
//
//        Stack<Integer> order = new Stack();//5,15

//        List<Integer> list = new LinkedList<>();
//        list.add(5);
//        list.add(5);
//        list.add(5);
//        for(int i = 0; i < list.size(); i++){
//            System.out.println(list.get(i));
//        }


//        order.push(5);
//        order.push(15);
//        order.push(8);//2
//        order.push(0);
//        order.push(7);
//        order.remove(1);
//        order.insertElementAt(0,1);
//        System.out.println(order.get(3));
//        System.out.println(order.pop());
//        System.out.println(order.size());
//        System.out.println(order);
//        System.out.println();
//        System.out.println(order.isEmpty());
        List<Integer> list = new List<>();

//        list.push(-1,7); //+
//        list.push(4,7); //+


        list.push(5);
        list.push(5);
        list.push(5);
//        list.push(10,-1); //+

        list.push(1,4);
        System.out.println(list);

    }

}
