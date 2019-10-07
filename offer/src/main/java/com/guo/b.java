package com.guo;

public class b {
    public boolean Find(int target, int [][] array) {
        int row = array.length;
        int col = array[0].length;
        int r = 0;
        int c = col - 1;
        while (r < row && c >= 0){
            if (array[r][c]== target){
                return true;
            }else if (array[r][c] > target){
                c--;
            }else{
                r++;
            }
        }
        return false;
    }
}
