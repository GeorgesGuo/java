
import java.util.Arrays;
import java.util.Random;
import java.util.Stack;



public class TestSortDemo {
    //直接插入排序
    public static void insertSort(int[] array) {
        int j = 0;
        int tmp = 0;
        for (int i = 1; i < array.length; i++) {
            tmp = array[i];
            for (j = i - 1; j >= 0; j--) {
                if (array[j] > tmp) {
                    array[j + 1] = array[j];
                } else {
                    //array[j+1] = tmp;
                    break;
                }

            }
            array[j + 1] = tmp;

        }

    }


    //shell排序
    public static void shell(int[] array, int gap) {


        for (int i = gap; i < array.length; i++) {

            int tmp = array[i];
            int j = 0;
            for (j = i - gap; j >= 0; j--) {

                if (array[j] < tmp) {
                    array[j] = array[j + gap];
                } else {
                    break;
                }
            }
            array[j + gap] = tmp;

        }

    }

    public static void shellSort(int[] array) {
        int[] drr = {5, 3, 1};
        for (int i = 0; i < array.length; i++) {

            shell(array, i);

        }
    }


    //直接选择排序
    public static void selectSort(int[] array) {

        for (int i = 1; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {

                j = i + 1;
                if (array[i] > array[j]) {
                    int tmp = array[i];
                    array[j] = array[i];
                    array[i] = tmp;


                }


            }

        }


    }


    //冒泡排序


    public static void bubbleSort(int[] array) {
        boolean swap = false;
        for (int i = 0; i < array.length - 1; i++) {//趟数
            swap = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    swap = true;
                }
            }//一趟走完
            if (!swap) {
                break;
            }
        }
    }


    public static int partion(int[] array, int low, int high) {
        int tmp = array[low];
        if (low == high) {
            return -1;
        }
        if (low > high) {
            return -1;
        }
        while (low < high) {

            while (low < high && array[high] >= tmp) {
                high--;
            }

            if (low >= high) {
                array[low] = tmp;
                break;
            } else {
                array[low] = array[high];
                low++;

                while (low < high && array[high] >= tmp) {
                    high--;
                }

                if (low >= high) {
                    array[low] = tmp;
                    break;
                } else {
                    array[low] = array[high];
                }

            }

        }
        array[low] = tmp;
        return low;
    }


    //交换
    public static void swap(int[] array, int low, int high) {
        int tmp = array[low];
        array[low] = array[high];
        array[high] = tmp;
    }

    //三数取中法
    public static void medianOfTree(int[] array, int low, int high) {
        int mid = (low + high) / 2;
        if (array[mid] > array[low]) {
            swap(array, mid, low);
        }
        if (array[mid] > array[high]) {
            swap(array, mid, high);
        }
        //array[mid] <= array[low] <= array[high]

    }


    public static void insertSor2(int[] array, int start, int end) {
        int j = 0;
        int tmp = 0;
        for (int i = start + 1; i <= end; i++) {
            tmp = array[i];
            for (j = end; i <= start; i--) {
                if (tmp < start + 1) {
                    array[start] = array[i];
                    start++;
                } else {
                    //array[j+1] = tmp;
                    break;
                }

            }
            array[j + 1] = tmp;

        }
    }

    public static void quick(int[] array, int start, int end) {
        int par = partion(array, start, end);
        //递归左边
        if (par > start + 1) {
            quick(array, start, end);
        }
        //递归右边
        if (par < end - 1) {
            quick(array, par + 1, end);
        }
    }




    public static void quickSort1(int[] array){
        quick(array,0,array.length-1);

    }


    //非递归快速排序
    public static void quickSort(int[] array){
        Stack<Integer> stack = new Stack<>();
      int low = 0;
      int high = array.length-1;
      int par = partion(array, low, high);

      if(par> low +1){
          stack.push(low);
          stack.push(par-1);
      }
      if(par<high-1){
          stack.push(par+1);
          stack.push(high);
      }
      while (!stack.empty()){
          high = stack.pop();
          low = stack.pop();
      }

    }




//并归排序

    public static void mergSort(int []array,int start,int end){
        if(start>=end){
            return;
        }
        int mid = (start+end)/2;
        mergSort(array,start,mid);
        mergSort(array,mid+1,end);

        merge(array,start,mid,end);
    }
    //合并
    public static void merge(int[] array, int start, int mid, int end){
        int []tmpArray = new int[array.length];
        int tmpIndex = start;
        int i =start;
        int s2 = mid+1;
        //当有两个归并段
        while (start<=mid && s2<=end){
            if(array[start]< array[s2]){
                tmpArray[tmpIndex++] = array[start++];
            }else {
                tmpArray[tmpIndex++] = array[s2++];
            }
        }
        //第一归并段
        while (start<=mid){
            tmpArray[tmpIndex++] = array[start++];
        }
        //第二归并段
        while (s2<=end){
            tmpArray[tmpIndex++] = array[s2++];
        }
        //把排序好数据拷贝
        while (i<end){
            array[i] = tmpArray[i++];
        }
    }


    public static void merge2(int[]array,int gap) {
        int[]temArray = new int[array.length];
        int i =0;//tmpArray下标
        int start1 =0;
        int end1 = start1+gap-1;
        int start2 = end1+1;
        int end2 = start2+gap-1<=array.length-1?start2+gap-1:array.length-1;
        //保证有两个归并段
        while (start2<array.length-1){
            //两个归并段都有数据
            while (start1<=end1 && start2<=end2) {
                //开始比较
                if (array[start2] < array[start1]) {
                    temArray[i++] = array[start1++];


                } else {
                    temArray[i++] = array[start2++];
                }
            }
            while (start1<=end1) {
                    temArray[i++]= array[start1++];
            }
            while (start2<=end2){
                    temArray[i++]= array[start2++];
            }
            //证明一次二路归并已完成
            start1 = end2+1;
            end1 = start1+gap-1;
            start2 = end1+1;
            end2 = start2+gap-1<=array.length-1?start2+gap-1:array.length-1;
        }
        while (start1<array.length){
            temArray[i++]= array[start1++];
        }
        //拷贝数据到原始数组
        for (int j = 0; j <temArray.length ; j++) {
            array[j] = temArray[j];
        }

    }

    //非递归归并排序
    public static void mergeSort2(int[] array) {
        for (int i = 1; i <array.length ; i*=2) {
            merge2(array,i);
        }

    }





    public static void main(String[] args) {
        int []array =new int[10];
        int []tmpArray = new int[array.length];
        Random random = new Random();
        for (int i = 0;i<array.length;i++){
            array[i]=random.nextInt(100);

        }

         mergeSort2(array);
        System.out.println(System.currentTimeMillis());
        System.out.println(Arrays.toString(array));
    }



}