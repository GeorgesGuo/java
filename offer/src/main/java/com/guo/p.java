package com.guo;

public class p {
    public void FindNumsAppearOnce1(int[] array, int[] num1, int[] num2)    {
        int length = array.length;
        if(length == 2){
            num1[0] = array[0];
            num2[0] = array[1];
            return;
        }
        int bitResult = 0;
        for(int i = 0; i < length; ++i){
            bitResult ^= array[i];
        }
        int index = findFirst1(bitResult);
        for(int i = 0; i < length; ++i){
            if(isBit1(array[i], index)){
                num1[0] ^= array[i];
            }else{
                num2[0] ^= array[i];
            }
        }
    }
    private int findFirst1(int bitResult){
        int index = 0;
        while(((bitResult & 1) == 0) && index < 32){
            bitResult >>= 1;
            index++;
        }
        return index;
    }
    private boolean isBit1(int target, int index){
        return ((target >> index) & 1) == 1;
    }


    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        for(int i = 0;i<array.length;i++){
            int tmp = array[i];
            for(int j =i+1;i<array.length;i++ ){
                if(array[i]== array[j]){
                    break;
                }else{
                    num1[0]= array[i];
                }
            }

        }
    }
}
