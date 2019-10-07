package com.guo;

public class a {
    public String replaceSpace(StringBuffer str) {
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<str.toString().length();i++){
            if(String.valueOf(str.charAt(i)).endsWith(" ")){
                sb.append("%20");
            }else{
                sb.append(String.valueOf(str.charAt(i)));
            }
        }
        return sb.toString();
    }

    public boolean Find(int target, int [][] array) {
      /*  一种是：
        把每一行看成有序递增的数组，
        利用二分查找，
        通过遍历每一行得到答案，
        时间复杂度是nlogn
*/
        for(int i=0;i<array.length;i++){
           int low=0;
           int high=array[i].length-1;
            while(low<=high){
                int mid=(low+high)/2;
                if(target>array[i][mid])
                  low=mid+1;
                else if(target<array[i][mid])
                   high=mid-1;
                else
                   return true;
            }
        }
        return false;

    }
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers == null||length<=0){
            return false;
        }
        for (int i = 0; i <length ; i++) {
            if (numbers[i]<0||numbers[i]>length-1){
                return false;
            }
        }
        for (int i = 0; i <length ; i++) {
            while (numbers[i]!=i){
                if (numbers[i] == numbers[numbers[i]]){
                    duplication[0]=numbers[i];
                    return true;
                }
                int tmp = numbers[i];
                numbers[i] = numbers[tmp];
                numbers[tmp] = tmp;
            }
        }
        return false;
    }
}
