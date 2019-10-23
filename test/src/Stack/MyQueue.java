package Stack;

public class MyQueue implements IMyQueue {

    class Node{
        private int data;
        private Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    private Node front;
    private  Node rear;
    private  int usedSize;
    public MyQueue(){
        this.front = null;
        this.rear = null;
        this.usedSize = 0;
    }

    @Override
    public boolean empty() {
        return this.usedSize ==0;
    }
    // 返回队首元素，但不出队列
    @Override
    public int peek() {
        if (empty()){
            throw new UnsupportedOperationException("队列为空");
        }
        return this.front.data;
    }
    // 返回队首元素，并且出队列
    @Override
    public int poll() {
        if (empty()){
            throw new UnsupportedOperationException("队列为空");
        }
        int oldData = this.front.data;
        this.front = this.front.next;
        this.usedSize--;
        return oldData;
    }
    // 将 item 放入队列中
    @Override
    public void add(int item) {
        Node node = new Node(item);
        if (empty()){
          this.front = node;
          this.rear = node;
        }else {
            this.rear.next = node;
            this.rear =this.rear.next;
        }
        this.usedSize++;
    }

    @Override
    public int size() {
        return this.usedSize;
    }
}
