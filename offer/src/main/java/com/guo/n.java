package com.guo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class n {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer>num =new ArrayList<Integer>();
        int left = 0,right = array.length-1;
        while (left < right){
            if(array[left] + array[right] < sum){
                left++;
            }
            else if(array[left] + array[right] > sum)
                right--;
            else
            {
                num.add(array[left]);
                num.add(array[right]);
                return num;
            }
        }
        return num;
    }
}
