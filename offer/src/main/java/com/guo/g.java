package com.guo;

public class g {
    public int JumpFloorII(int target) {
        int [] arr = new int[target+1];
        arr[0] = 0;
        arr[1] = 1;
        for(int i = 2;i<=target;++i){
            arr[i] = 2*arr[i-1];
        }
        return arr[target];
    }
}

