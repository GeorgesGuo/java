package com;

import java.util.Arrays;
import java.util.Scanner;

public class newarr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        String [] str = sc.nextLine().split("\\ ");
        int [ ] arr = new int [str.length];
        for (int i = 0; i <num ; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        change(num,arr);
        System.out.println(Arrays.toString(change(num,arr)));
    }

    public static int [ ] change(int num,int [] arr ) {
        int [ ] newArr = new int[ num];
        newArr[0] = 1;
        for(int i = 1; i < num;i++) {
            newArr[0] *= arr[i-1];
            newArr[i] = newArr[0];
        }
        newArr[0] = 1;
        for(int i = num-2;i >0;i--) {
            newArr[0] *= arr[i+1];
            newArr[i] *= newArr[0];
        }
        newArr[0] *= arr[1];

        return newArr;
    }

}
