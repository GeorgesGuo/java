package com.guo;

import java.util.ArrayList;
import java.util.List;

public class i {
    public static void main(String[] args) {
        int []array = {1,2,3,4,5,6,7};
        reOrderArray(array);
        for (int i = 0; i <array.length ; i++) {
            System.out.println(array[i]);
        }
    }
    public static void reOrderArray(int [] array) {
        for(int i=0;i<array.length-1;i++)
            for(int j=0;j<array.length-i-1;j++){
                if(array[j]%2==0 && array[j+1]%2==1){
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
    }
}