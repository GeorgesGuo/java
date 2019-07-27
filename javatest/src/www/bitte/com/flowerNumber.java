package www.bitte.com;

import java.util.ArrayList;
import java.util.Scanner;

class Test{
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int start = input.nextInt();
        int end = input.nextInt();// 系统输入两个整数
        //
          ArrayList<Integer> out = flower(start, end);
        // 调用方法
       if (out.isEmpty()){
        // 判断是否为空，按格式输出no。
        System.out.println("no");
       } else {
           for (int i = 0; i < out.size(); i++) {
               // 按格式输出
               if (i != out.size() - 1) {// 最后一个不需要输出空格
                    System.out.print(out.get(i) + " ");
               } else {
                   System.out.print(out.get(i));
               }
           }
       }
    }
    public static ArrayList<Integer> flower(int startNumber, int endNumebr) {
        ArrayList<Integer> flowerNumber = new ArrayList<Integer>();
        int j = 0;
        for (int i = startNumber; i < endNumebr; i++) {
            /*             * 若满足条件放入数组 条件是分别取出3个位的数的3次方相加==原数             */
            if ((i == Math.pow(Math.floor(i / 100), 3) + Math.pow(Math.floor(i % 100 / 10), 3)
                    + Math.pow(i % 100 % 10, 3)) && i >= startNumber && i <= endNumebr) {
                flowerNumber.add(i);
            }
        }
        return flowerNumber;// 返回数组
         }
}

