package com.guo;

import java.util.Arrays;
import java.util.Scanner;

public class z {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String a = str.replaceAll(",","");
        int [] num = new int[a.length()];
        for (int i = 0; i <a.length() ; i++) {
            Character ch = a.charAt(i);
            num [i]=  Integer.parseInt(ch.toString());
        }
        Arrays.sort(num);
    }
}
