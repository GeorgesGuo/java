package com.guo;

import java.util.Scanner;

public class y {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        System.out.println(find(getint(str1), getint(str2)));
    }
    private static int[] getint(String str) {
        String str1 = str.replaceAll(",","");
        int [] num1 = new int[str1.length()];
        for (int i = 0; i <str1.length() ; i++) {
            Character ch = str1.charAt(i);
            num1 [i]=  Integer.parseInt(ch.toString());
        }
        return num1;
    }
    public static double find (int[] num1,int[]num2){
        int a = num1.length;
        int b = num2.length;
        int [] c = new int[a+b];
        int i = 0,j=0,k=0;
        while(i<a&&j<b){
            c[k++] = num1[i]<num2[j]?num1[i++]:num2[i++];
        }
        while (j<b){
            c[k++] = num2[j++];
        }
        double result;
        if(((a+b)&1)==1)result = c[(a+b)>>1];
        else  result = (c[(a+b)/2-1]+c[(a+b)>>1])*1.0/2;
        return  result;
    }
}
