public class TextDemo {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-13);
        minStack.push(1);
        minStack.push(-53);
        minStack.push(-35);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());

    }
}
