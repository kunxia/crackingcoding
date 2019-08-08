package com.kunxia.others;

public class Fibonacci {
    public int fib(int n){
      if(n <= 1) return n;
      return fib(n-1)+fib(n-2);
    }
}

//public class FibonacciSeries2{
//    public static void main(String args[]) {
//        int a, b, c, n;
//        n = 10;
//        a = b = 1;
//        System.out.print(a+" "+b);
//        for(int i = 1; i <= n-2; i++) {
//            c = a + b;
//            System.out.print(" ");
//            System.out.print(c);
//            a = b;
//            b = c;
//        }
//    }
//}