package com;

import java.util.Scanner;

public class num {
    /*,
    2. 给定⼀个有序递增的整数序列，判断它是否为⼀个阶梯序列
    阶梯序列的定义为：假如存在⼀个数，这个数右边的⼦序列之和是左边的⼦序
    列之和的两倍，即为阶梯序列
    样例：
    输⼊：第⼀⾏是给数组的数量，第⼆⾏为数组元素的值
    5
    2，3，4，6，8，10
    输出：1 （是阶梯序列返回1，不是阶梯序列返回 -1）
*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] str = sc.nextLine().split(",");
        int[] arr = new int[str.length];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        System.out.println(increase(arr));
    }

    private static int increase(int[] arr) {
        int left = 0;
        int right = 0;
        for (int i = 1; i < arr.length; i++) {
            right+=arr[i];
        }
        for (int i = 1; i < arr.length; i++) {
            left+=arr[i-1];
            right-=arr[i];
            if(left*2==right){
                return 1;
            }
        }
        return -1;
    }


}
