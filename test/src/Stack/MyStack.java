package Stack;
//栈
public class MyStack implements IMyStack {
    //存放数据元素的数组
    private int[] elem;
    //当前可以存放数据元素的下标
    private int top;
    private int useSize;

    public MyStack(int size){
        this.elem = new int[10];
        this.top = 0;
        this.useSize = 0;
    }
    //判满
    private boolean isFull(){
        return this.top ==this.elem.length;
    }
    @Override
    public void push(int item) {
        if(isFull()){
            throw new  UnsupportedOperationException("栈为满");
        }
        this.elem[this.top++] = item;
        this.useSize++;
    }
    // 返回栈顶元素，并且出栈
    @Override
    public int pop() {
        if(empty()){
            throw new UnsupportedOperationException("栈空");
        }
        this.top --;
        this.useSize--;
        return  this.elem[this.top];
    }
    // 返回栈顶元素，但不出栈
    @Override
    public int peek() {
        if(empty()){
            throw new UnsupportedOperationException("栈空");
        }
        return this.elem[this.top-1];
    }

    @Override
    public boolean empty() {
        return this.useSize==0;
    }

    @Override
    public int size() {
        return this.useSize;
    }
}
