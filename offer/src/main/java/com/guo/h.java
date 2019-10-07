package com.guo;

public class h {
    public int RectCover(int target) {
        if(target == 0)
            return 0;
        int [] arr = new int[target+1];
        arr[0] = 1;
        arr[1] = 1;
        if(target>1){
            for(int i = 2; i <= target; ++i){
                arr[i] = arr[i-1] + arr[i-2];
            }
        }
        return arr[target];
    }
}
