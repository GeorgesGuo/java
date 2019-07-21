public class MyDoubleLinked implements IDoubleLinked {

    class Node{
        private int data;
        private  Node prev;//前驱
        private  Node next;//后继

        public  Node (int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }


    private  Node head;
    private  Node last;//标志尾巴
    public  MyDoubleLinked(){
        this.head =null;
        this.last =null;
    }
    @Override
    public void addFirst(int data) {
        //第一次插入
        Node node = new Node (data);
        if(head == null){
            this.head = node;
            this.last = node;
        }else{
            //非第一次插入
            node.next = this.head;
            node.next.prev = node;
            this.head = node;
        }


    }

    @Override
    public void addLast(int data) {

    }

    @Override
    public boolean addIndex(int index, int data) {
        return false;
    }

    @Override
    public boolean contains(int key) {
        return false;
    }

    @Override
    public int remove(int key) {
        return 0;
    }

    @Override
    public void removeAllKey(int key) {

    }

    @Override
    public void display() {

    }

    @Override
    public void clear() {

    }
}
