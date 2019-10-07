package com.guo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class q {
    public int NumberOf1Between1AndN_Solution(int n) {
        int sum = 0;
        int [] num = new int[n];
        for (int i = 0; i <n ; i++) {
            num[i]= i;
        }
        if (Arrays.asList(num).contains(1)){
            sum++;
        }
        return sum;
    }
}
