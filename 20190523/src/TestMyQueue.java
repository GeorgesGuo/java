import java.util.Stack;
//两个栈实现队列
public class TestMyQueue {
    class MyQueue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;

        /** Initialize your data structure here. */
        public MyQueue() {
            stack1 = new Stack<Integer>();
            stack2 = new Stack<Integer>();

        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            stack1.push(x);

        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if ( stack2.empty()){
                while (!stack1.empty()){
                    stack2.push(stack1.pop());
                }
            }
            int tmp =0;
            if ( !stack2.empty() ){
                tmp = stack2.pop();
            }
                return tmp;

        }

        /** Get the front element. */
        public int peek() {
            if ( stack2.empty()){
                while (!stack1.empty()){
                    stack2.push(stack1.pop());
                }
            }
            int tmp =0;
            if ( !stack2.empty() ){
                tmp = stack2.peek();
            }
            return tmp;
        }

        /** Returns whether the queue is empty. */
        //判断队列是否为空
        public boolean empty() {
            return  stack1.empty()&&stack2.empty();
        }
    }
}
