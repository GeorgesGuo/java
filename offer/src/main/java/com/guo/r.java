package com.guo;

public class r {
    public static void main(String[] args) {
        System.out.println(NumberOf1Between1AndN_Solution(11));
    }
    public static int NumberOf1Between1AndN_Solution(int n) {
        int sum =0;
        int strlen = 0;
        for (int i = 0; i <=n ; ++i) {
            String str  = String.valueOf(i);
            strlen = str.length();
            for(int j = 0 ;j<strlen;j++){
                if(str.charAt(j)=='1'){
                    sum ++;
                }
            }
        }
        return sum;
    }
}
