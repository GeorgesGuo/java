import java.util.LinkedList;

public class Test2 {


    private LinkedList<Integer> queue1;
    private LinkedList<Integer> queue2;
    private int size;
    /** Initialize your data structure here. */
    public Test2() {
        this.queue1 = new LinkedList<Integer>();
        this.queue2 = new LinkedList<Integer>();
        this.size = 0;
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if(queue1.peek() != null){
            queue1.offer(x);
        }else if(queue2.peek() != null){
            queue2.offer(x);
        }else{
            //都为空，则用queue1开始
            queue1.offer(x);
        }
        size++;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(empty()){
            throw new RuntimeException("无数据");
        }
        int e = 0;
        if(queue2.peek() != null){
            for(int i = 0; i < size - 1; i++){
                queue1.offer(queue2.poll());
            }
            e = queue2.poll();
        }else{
            for(int i = 0; i < size - 1; i++){
                queue2.offer(queue1.poll());
            }
            e = queue1.poll();
        }
        this.size--;
        return e;
    }

    /** Get the top element. */
    public int top() {
        if(empty()){
            throw new RuntimeException("无数据");
        }
        int e = 0;
        if(queue2.peek() != null){
            for(int i = 0; i < size; i++){
                e = queue2.poll();
                queue1.offer(e);
            }
        }else{
            for(int i = 0; i < size; i++){
                e = queue1.poll();
                queue2.offer(e);
            }
        }
        return e;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return size == 0;
    }

    public int size(){
        return this.size;
    }

}
