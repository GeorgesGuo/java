import java.util.Arrays;
import java.util.Random;

public class Test5 {
    public int count(int[] A, int n) {
        if (A == null || n == 0)
        {
            return 0;
        }
        return mergeSortRecurion(A,0,n-1);
    }
    public static int mergeSortRecurion(int[]arr,int l,int r){
        if(l==r){
            return 0 ;
        }
        int mid = (l+r)/2;
        return mergeSortRecurion(arr,l,mid)
                +mergeSortRecurion(arr,mid+1,r)
                +merge(arr,l,mid,r);
    }
    public static int merge(int[]arr,int left,int mid,int right){
        int []temp = new int [right - left + 1];
        int index = 0;
        int i = left;
        int j = mid+1;
        int inverseNum = 0;
        while(i <= mid && j<=right){
            if(arr[i] <= arr[j]){
                temp[index++] = arr[i++];
            }else{
                inverseNum +=(mid - i + 1);
                temp[index++] = arr[j++];
            }
        }
        while(i <= mid){
            temp[index++] = arr[i++];
        }
        while(j <= right){
            temp[index++] = arr[j++];
        }
        for(int k = 0;k < temp.length;k++){
            arr[left++] = temp[k];
        }
        return inverseNum;
    }

    public static void main(String[] args) {

    }
}
