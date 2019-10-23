package LinkAndSequence;

// 不带头双向链表实现
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
        if(last == null){
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
        Node node = new Node (data);
        //第一次插入
        if(this.head == null){
            this.head = node;
            this.last = node;
        }else{
            //非第一次插入
            this.last.next = node;
            node.prev = this.last;
            this.last = node;
        }
    }

    @Override
    public boolean addIndex(int index, int data) {
        if(index ==0){
            addLast(data);
            return true;
        }
        if (index == getLength()){
            addLast(data);
            return true;
        }
        Node cur = searchIndex(index);
        //cur指向index的结点
        Node node = new Node(data);

        node.next = cur;
        cur.prev.next = node;
        node.prev =cur.prev;
        cur.prev = node;
        return true;
    }

    private Node searchIndex (int index){
        checkIndex(index);
        int count =0;
        Node cur = this.head;
        while (count != index){
            cur = cur.next;
            count ++;
        }
        return cur;
    }
    private void checkIndex(int index){
        if(index<0 ||index > getLength()){
            throw new UnsupportedOperationException("index位置不合法");
        }
    }

    @Override
    public boolean contains(int key) {
        Node cur = this.head;
        while (cur!=null){
            if (cur.data == key){
                return true;
            }
            cur= cur.next;
        }
        return false;
    }

    @Override
    public int remove(int key) {
        Node cur = this.head;
        int oldData = 0;
        while (cur!=null){
            if (cur.data == key){
                oldData = cur.data;
                if (cur ==this.head){
                    this.head = this.head.next;
                    this.head.prev = null;
                }else {
                    cur.prev.next = cur.next;
                    if(cur.next!= null){
                        cur.next.prev = cur.prev;
                    }else {
                        this.last = cur.prev;
                    }
                }
                return oldData;
            }
            cur = cur.next;

        }
        return -1;
    }

    @Override
    public void removeAllKey(int key) {
        Node cur = this.head;
        while (cur != null){
            if(cur.data == key){
                if (cur ==this.head){
                    this.head = this.head.next;
                    this.head.prev = null;
                }else {
                    cur.prev.next = cur.next;
                    if (cur.next != null){
                        cur.next.prev = cur.prev;
                    }else {
                        this.last = cur.prev;
                    }
                }
            }
            cur = cur.next;
        }


    }

    @Override
    public int getLength() {
        int count = 0;
        Node cur = this.head;
        while (cur != null){
            cur = cur.next;
            count ++;
        }
        return count;
    }

    @Override
    public void display() {
        Node cur = this.head;
        while (cur != null){
            System.out.print(cur.data +" ");
            cur = cur.next;
        }
        System.out.println();
    }

    @Override
    public void clear() {
        while (this.head!=null){
            Node cur = this.head.next;
            this.head.next = null;
            this.head.prev = null;
            this.head = cur;
        }
    }
}
