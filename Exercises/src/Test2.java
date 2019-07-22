import java.util.Arrays;
import java.util.Random;

//快速排序，寻找第K大
public class Test2 {
        public   int findKth(int[] a ,int k) {
            return findKth(a, 0, a.length,k);
        }
        public  static int findKth(int[] a, int low, int high, int k) {
            int part = partion(a, low, high);
            if(k == part - low + 1)
                return a[part];
            else if(k > part - low + 1)
                return findKth(a, part + 1, high, k - part + low -1);
            else return findKth(a, low, part -1, k);
        }
        public  static int partion(int[] a, int low, int high) {
            int key = a[low];
            while(low < high) {
                while(low < high && a[high] <= key)
                    high--;
                a[low] = a[high];
                while(low < high && a[low] >= key)
                    low++;
                a[high] = a[low];
            }
            a[low] = key;
            return low;
        }

    public static void main(String[] args) {
       int [] a = new int[10];
        Random random = new Random();
        for (int i = 0;i<a.length;i++){
            // array[i] = i;//有序数列
            a[i] = random.nextInt(10000);//无序数列，[1,1000)
        }
                System.out.println(Arrays.toString(a));
        System.out.println(findKth(a,0,a.length-1,4));
    }
}
