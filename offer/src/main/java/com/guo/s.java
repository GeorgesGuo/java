package com.guo;

import java.util.ArrayList;

public class s {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> max = new ArrayList<Integer>();
        if(num.length == 0 || size <= 0 ||size > num.length){
                return max;
        }
        for (int i = 0; i <num.length - size+1 ; i++) {
            int maxer = 0;
            for (int j = i; j <i+size; j++) {
                if (maxer<num[j]){
                    maxer = num[j];
                }
            }
            max.add(maxer);
        }
        return max;
    }
}
