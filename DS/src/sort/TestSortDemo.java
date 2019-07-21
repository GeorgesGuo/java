package sort;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

public class TestSortDemo {
//直接插入排序
//时间复杂度：O(n^2) 最好：O(n)   越有序越快
//空间复杂度：O(1)
//稳定性：稳定
    public static void  insertSort(int [] array){
        long star = System.currentTimeMillis();
        //遍历数组
        for (int i = 1; i <array.length ; i++) {
            int tmp = array[i];
            int j;
            for ( j = i-1; j >= 0 ; j--) {
                if ( array[j]>tmp ){
                    array[j+1]=array[j];
                }else {
                   // array[j+1] = tmp;
                    break;
                }
            }
            array[j+1]=tmp;
        }
        long end = System.currentTimeMillis();
        System.out.println("算法执行时间"+(end-star));//时间单位：毫秒
    }

    /*shell排序，直接插入排序的优化
    时间复杂度：O(n^1.3-1.5)
    空间复杂度：O(1)
    稳定性：不稳定
    */
    public static void shell(int[]array,int gap){
        long star = System.currentTimeMillis();
        //遍历数组
        for (int i = gap; i <array.length ; i++) {
            int tmp = array[i];
            int j=0;
            for ( j = i-gap; j >= 0 ; j-=gap) {
                if ( array[j]>tmp ){
                    array[j+gap]=array[j];
                }else {
                    // array[j+1] = tmp;
                    break;
                }
            }
            array[j+gap]=tmp;
        }
        long end = System.currentTimeMillis();
        System.out.println("算法执行时间"+(end-star));//时间单位：毫秒
    }
    public static void shellSort(int[]array){
        int[]drr = {5,3,1};
        for (int i = 0; i <drr.length ; i++) {
            shell(array,drr[i]);
        }
    }


     /*选择排序
    时间复杂度：O(n^2)
    空间复杂度：O(1)
    稳定性：不稳定
    */
    public static void selectSort(int[] array) {
        for (int i = 0; i <array.length ; i++) {
            for (int j = i+1; j <array.length ; j++) {
                if(array[j]<array[i]){
                    int tmp = array[j];
                    array[j] = array[i];
                    array[i] = tmp;
                }
            }
        }
    }

   /*
   * 冒泡排序
   *  时间复杂度：O(n^2)  最好情况下：O(n)
    空间复杂度：O(1)
    稳定性：稳定

   * */
   public static void bubbleSort (int array[]){
       boolean swap = false;
       for (int i = 0; i <array.length-1; i++) {//趟数
           swap = false;
           for (int j = 0; j <array.length-1-i ; j++) {
               if ( array[j] >array[j+1] ) {
                   int tmp = array[j];
                   array[j]= array[j+1];
                   array[j+1]=tmp;
                   swap = true;
               }
           }
           if(!swap) {
               break;
           }
       }
   }

   /*
   * 快速排序(递归)
   *时间复杂度：O(N*logN)   最坏情况：O(N^2)\
   * 空间复杂度： O(logN)    最坏情况：O(n)
   * 稳定性：不稳定
   */

   public static int partion(int[] array,int low,int high) {
       int tmp = array[low];
       while (low < high) {
           while (low < high && array[high] >= tmp) {
               high--;
           }
           if ( low >= high ) {
               array[low] = tmp;//可删除
               break;
           } else {
               array[low] = array[high];
           }
           while (low < high && array[low] <= tmp) {
               low++;
           }
           if ( low >= high ) {
               array[low] = tmp;//可删除
               break;

           } else {
               array[high] = array[low];
           }
       }
       array[low] =tmp;
       return low;
   }
   public static void quick(int[] array,int start,int end){
       //优化1
       medianOfThree(array,start,end);
       int par = partion(array,start,end);
       //递归左边
       if(par>start+1){
           quick(array,start,par-1);
       }
       //递归右边
       if(par< end-1){
           quick(array,par+1,end);
       }
   }
    public static void quickSort(int[] array) {
       quick(array,0,array.length-1);
    }

    //快排优化1
    public static  void swap(int [] array,int low,int high){
       int tmp =array[low];
       array[low] = array[high];
       array[high] = tmp;
    }

    public static  void medianOfThree(int [] array,int low,int high){
       int mid = (low +high)/2;
       if ( array[mid]>array[low] ){
           swap(array,mid,low);
       }
       if ( array[mid]>array[high] ){
           swap(array,mid,high);
       }
       if ( array[low]>array[high] ){
           swap(array,low,high);
       }
       //array[mid]<= array[low] <= array[high];
    }

/*
   * 快速排序(非递归)
   *
*/
public static void quickSort1(int[] array){
    //用集合表示栈
    Stack<Integer>stack = new Stack<>();
    int low = 0;
    int high = array.length-1;
    int par = partion(array,low,high);
    //左边
    if ( par> low+1 ){
        stack.push(low);
        stack.push(par-1);
    }
    //右边
    if ( par<high-1 ){
        stack.push(par+1);
        stack.push(high);
    }
    while (!stack.empty()){
        high = stack.pop();
        low = stack.pop();

         par = partion(array,low,high);
        //左边
        if ( par> low+1 ){
            stack.push(low);
            stack.push(par-1);
        }
        //右边
        if ( par<high-1 ){
            stack.push(par+1);
            stack.push(high);
        }
    }
}

//归并排序
    //时间复杂度：O(NlogN)
    //空间复杂度O(N)
    //稳定性：稳定
    public static void mergeSort(int[] array,int start,int end){
    //递归结束条件
        if ( start>= end ){
        return;
    }
    int mid = (start+end)/2;
    //左边
    mergeSort(array,start,mid);
    //右边
    mergeSort(array,mid+1,end);

    //合并函数
        merge(array,start,mid,end);
    }

public static void merge(int[] array,int start,int mid,int end){
    int []tmpArray = new int [array.length];
    int tmpIndex = start;
    int i= start;
    int s2 = mid+1;
    //当有两个归并段时
    while (start<=mid && s2 <=mid){
        if(array[start]<= array[s2]){
            tmpArray[tmpIndex++] = array[start++];
        }else {
            tmpArray[tmpIndex++] = array[s2++];
        }
    }
    //第一个归并段有数据
    while (start<=mid){
        tmpArray[tmpIndex++] = array[start++];

    }
    while (s2 <=mid){
        tmpArray[tmpIndex++] = array[s2++];
    }
    //把排好序的数据从tmpArray中拷贝到array中
    while (i<end){
        array[i] = tmpArray[i];
        i++;
    }

}



    public static void main(String[] args) {
       int [] array = new int[1000];
        Random random = new Random();
        for (int i = 0;i<array.length;i++){
           // array[i] = i;//有序数列
            array[i] = random.nextInt(10000);//无序数列，[1,1000)
        }

      // int [] array = {10,2,-2,4,33,98,21,11};
//        System.out.println(Arrays.toString(array));
//        insertSort(array);
//        System.out.println(Arrays.toString(array));
//        shellSort(array);
//        System.out.println(Arrays.toString(array));
//        bubbleSort(array);
//        System.out.println(Arrays.toString(array));
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
