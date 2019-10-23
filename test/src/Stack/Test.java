package Stack;

public class Test {
    public static void main(String[] args) {
        MyStack myStack = new MyStack(10);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        System.out.println(myStack.size());//5
        System.out.println(myStack.empty());//false
        System.out.println(myStack.pop());//5
        System.out.println(myStack.peek());//4
    }
}
