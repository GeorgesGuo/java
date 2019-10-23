package com.guo;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

import static com.sun.org.apache.xalan.internal.lib.ExsltStrings.split;

public class PKsort {
    /*
    1·将⼀组忽略⼤王⼩王的扑克牌，从⼩到⼤排序，请尽量选择时间复杂度低的⽅
    案（忽略花⾊，2最⼤，A⽐K⼤，2⽐A⼤）
    输⼊:
    第⼀⾏是给出牌的数量，第⼆⾏为牌的值
    5
    J Q Q A K 3 2
    输出:
    3 J Q Q K A 2
    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        String [] str = sc.nextLine().split("\\ ");
        sort(str);
        for (int i = 0; i <num ; i++) {
            System.out.print(str[i]+" ");
        }
    }
    private static String [] sort( String [] str) {
        String point = "3 4 5 6 7 8 9 10 J Q K A 2";
        boolean swap = false;
        for (int i = 0; i < str.length; i++) {
            swap = false;
            for (int j = 0; j <str.length-1 ; j++) {
                int result= point.indexOf(str[j]) - point.indexOf(str[j+1]);
                if(result>0){
                    String tmp = str[j];
                    str[j] = str[j+1];
                    str[j+1] = tmp;
                    swap= true;
                }
            }
            if(!swap){
                break;
            }
        }
        return str;
    }
}
