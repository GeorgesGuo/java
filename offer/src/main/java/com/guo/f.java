package com.guo;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class f {
    static int count = 0;
    public static void main(String[] args) {

        System.out.println(Fibonacci(50));
        System.out.println(count);
    }
    public static long Fibonacci(int n) {
        long f1 = 1;
        long f2 = 1;
        if(n<=0){
            return   0;
        }else if(n==1||n==2){
            return   1;
        }
        while (n-- > 2){
            f1 += f2;
            f2 = f1-f2;
        }
         return f1;
    }
}
