public class MinStack {
    //最小栈


    //构造函数
    int [] stack = new int [10];
    int i = 0;//i表示 stack下标

    int[] minStack = new int[10];
    int j = 0;//最小栈


    public void push(int x) {
        stack[i++] = x;
        if(j==0){
            minStack[j++] =x;

        }else {
            if ( x <= minStack[j-1] ){
                minStack[j++] =x;
            }
        }


    }

    public void pop() {
        //不为空则可以出栈
        if(i != 0){
          int data = stack[--j];
            if ( data == minStack [j-1]) {
                --j;
            }
        }

    }

    public int top() {

        if ( i !=0 ){
            return stack [i-1];
        }
        return -1;
    }

    //得到当前栈内最小值
    public int getMin() {
        if ( j !=0 ){
            return minStack[j-1];
        }else {
            return -1;
        }


    }
}
