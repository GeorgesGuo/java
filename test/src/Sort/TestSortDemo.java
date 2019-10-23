package Sort;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

public class TestSortDemo {
//直接插入排序
    public static void insertSort(int[]array){
        long start = System.currentTimeMillis();
        for (int i = 0; i <array.length ; i++) {
            int tmp = array[i];
            int j = 0;
            for ( j = i-1; j >=0 ; j--) {
                if(array[j]>tmp){
                    array [j+1]=array[j];
                }else{
                    break;
                }
            }
            array[j+1]=tmp;
        }
        long end = System.currentTimeMillis();
        System.out.println("算法执行时间"+(end-start));
    }

    //shell排序:直接插入排序的优化
    public static void shell(int[]array,int gap){
        for (int i = gap; i <array.length ; i++) {
            int tmp = array[i];
            int j = 0;
            for (j=i-gap;j>=0;j-=gap){
                if (array[j]>tmp){
                    array[j+gap]= array[j];
                }else {
                    break;
                }
            }
            array[j+gap]=tmp;
        }
    }
    public static void shellSort(int[]array){
        int[]drr ={5,3,1};
        for (int i = 0; i <drr.length ; i++) {
            shell(array,drr[i]);
        }
    }
    //选择排序
    public static void selectSort(int []array){
        for (int i = 0; i <array.length ; i++) {
            for (int j = i+1; j <array.length ; j++) {
                if (array[j]<array[i]){
                    int tmp = array[j];
                    array[j]=array[i];
                    array[i]=tmp;
                }
            }
        }
    }
    //冒泡排序
    public static void bubbleSort(int[]array){
        boolean swap = false;
        for (int i = 0; i <array.length-1 ; i++) {
            swap = false;
            for (int j=0;j<array.length-i-1;j++){
                if (array[j]>array[j+1]){
                    int tmp = array[j];
                    array[j]=array[j+1];
                    array[j+1]=tmp;
                    swap = true;
                }
            }
            if(!swap){
                break;
            }
        }
    }


    //快速排序
    public static int partion(int[] array,int low,int high) {
        int tmp =  array[low];
        while (low < high) {
            while (low < high && array[high] >= tmp) {
                high--;
            }
            if(low>=high){
                break;
            }else {
                array[low]= array[high];
            }
            while (low < high && array[low] <= tmp) {
                low++;
            }
            if(low >= high) {
                break;
            }else {
                array[high] = array[low];
            }
        }
        array[low] = tmp;
        array[high]=tmp;
        return low;
    }
    public static void quick(int[]array,int start,int end){
        medianOfThree(array,start,end);
        int par = partion(array,start,end);
        //递归左边
        if(par>start+1){
            quick(array,start,par-1);

        }
        if(par<end-1){
            quick(array,par+1,end);
        }
    }
    public static void quickSort1(int[] array){
        quick(array,0,array.length-1);

    }
    //快排优化1：三数取中法
    public static void medianOfThree(int[]array, int low, int high){
        int mid = (low+high)/2;
        if(array[mid]>array[low]){
            swap(array,mid,low);
        }
        if(array[mid]>array[high]){
            swap(array,mid,high);
        }
        if (array[low]>array[high]){
            swap(array,low,high);
        }
    }
    public static  void swap(int[] array,int low,int high){
        int tmp = array[low];
        array[low]=array[high];
        array[high]=tmp;
    }

    //非递归快排：
    public static void quickSort(int[]array){
        Stack<Integer>stack= new Stack<>();
        int low=0;
        int high = array.length-1;
        int par = partion(array,low,high);
        if(par>low+1){
            stack.push(low);
            stack.push(par-1);
        }
        if(par<high-1){
            stack.push(par+1);
            stack.push(high);
        }
        while (!stack.empty()){
            high=stack.pop();
            low=stack.pop();
            par=partion(array,low,high);
            if(par>low+1){
                stack.push(low);
                stack.push(par-1);
            }
            if(par<high-1){
                stack.push(par+1);
                stack.push(high);
            }
        }
    }


    //归并排序(递归)
    public static void mergeSort(int[]array,int start,int end,int[]tempArray){
        if(start>=end){
            return;
        }
        int mid = (start+end)/2;
        mergeSort(array,start,mid,tempArray);

        mergeSort(array,mid+1,end,tempArray);

        merge(array,start,mid,end,tempArray);
    }
    public static void merge(int[] array,int start,int mid,int end,int[]tempArray){

        int tmpIndex = start;
        int i=start;
        int s2 =mid+1;
        //两个归并段时
        while (start<=mid&&s2<=end){
            if(array[start]<array[s2]){
                tempArray[tmpIndex++]=array[start++];
            }else {
                tempArray[tmpIndex++]=array[s2++];
            }
        }
        while (start<=mid){
            tempArray[tmpIndex++]=array[start++];
        }
        while (s2<=end){
            tempArray[tmpIndex++]=array[s2++];
        }
        //排好序的数据从tmpArray里面拷贝到array
        while (i<=end){
            array[i]=tempArray[i++];
        }

    }
    //归并排序（非递归）
    public static void mergeSort2(int[]array){
        for (int i =1;i<array.length;i*=2){
            merge2(array,i);
        }
    }
    //进行归并
    public static void merge2(int[]array,int gap){
        int []tmpArray = new int[array.length];
        int i =0;//tmpArray下标
        int start1 = 0;
        int end1 = start1+gap-1;
        int start2 = end1+1;
        int end2 = start2+gap-1<= array.length-1?start2+gap-1:array.length-1;
        //保证有两个归并段
        while (start2<array.length){
            //两个归并段都有数据
            while (start1<=end1&&start2<=end2) {
                //开始比较
                if (array[start1] <= array[start2]) {
                    tmpArray[i++] = array[start1++];
                } else {
                    tmpArray[i++] = array[start2++];
                }
            }
            while (start1<=end1){
                tmpArray[i++]=array[start1++];
            }
            while (start2<=end2){
                tmpArray[i++]=array[start2++];
            }
            //上面已经证明一次二路归并完成
            start1 = end2+1;
            end1=start1+gap-1;
            start2=end1+1;
            end2 = start2+gap-1<= array.length-1?start2+gap-1:array.length-1;
        }
        while (start1<array.length){
            tmpArray[i++]=array[start1++];
        }
        //拷贝数据到原始数组
        for (int j = 0; j <tmpArray.length ; j++) {
            array[j] = tmpArray[j];
        }
    }

    public static void main(String[] args) {
        int []array =new int[7];
        int[]tmpArray = new int[array.length];
        Random random = new Random();
        for(int i =0;i<array.length;i++){
            array[i]=random.nextInt(10)+1;
        }
        System.out.println(Arrays.toString(array));
       //insertSort(array);
        //shellSort(array);
        //selectSort(array);
       // bubbleSort(array);
       quickSort(array);
        //quickSort1(array);
        //mergeSort(array,0,array.length-1,tmpArray);
       // mergeSort2(array);
        System.out.println(Arrays.toString(array));
    }
}
