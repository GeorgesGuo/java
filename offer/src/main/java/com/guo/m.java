package com.guo;

import java.util.ArrayList;


public class m {
    public static void main(String[] args) {
        System.out.println(FindContinuousSequence(10));
    }
    public static  ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer> > num = new ArrayList<ArrayList<Integer>>();
        int left = 1;
        int right = 2;
        while(left < right){
            if(right > sum)
                return num;
            int temp = (left+right)*(right-left+1)/2;
            if(temp == sum){
                ArrayList<Integer> list = new ArrayList<Integer>();
                for (int i = left; i <=right ; i++) {
                    list.add(i);
                }
                num.add(list);
                right++;
            }else if(temp > sum){
                left++;
            }else {
                right++;
            }
        }
        return num;
    }
}
