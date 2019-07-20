public class MyQueueImp1 implements IQueue{

    class Node{
        private int data;
        private Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private  Node front;
    private  Node rear;
    private  int usedSize;

    public MyQueueImp1(){
        this.front = null;
        this.rear = null;
        this.usedSize = 0;
    }

    @Override
    public boolean empty() {
        return this.usedSize ==0;
    }

    //返回队首元素但不出队列
    @Override
    public int peek() {
        if(empty()){
            throw new UnsupportedOperationException("队列为空");
        }
        return this.front.data;
    }

    //返回队首函数并出队列
    @Override
    public int poll() {

        if(empty()){
            throw new UnsupportedOperationException("队列为空");
        }
        int oldData = this.front.data;
        this.front = this.front.next;
        this.usedSize--;
        return oldData;
    }

    @Override
    public void add(int item) {
        Node node = new Node(item);
        if(this.front ==null){
            this.front = node;
            this.rear = node;

        }else{
            this.rear.next = node;
            this.rear = node;

        }
        this.usedSize++;
    }

    @Override
    public int size() {
        return this.usedSize;
    }
}
