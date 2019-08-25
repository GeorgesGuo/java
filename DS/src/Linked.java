//无头单向非循环链表实现
public class Linked implements ILinked {
    //节点类
    class Node{
        private int data;
        private Node next;
        //初始化
        public Node(int data){
            this.data = data;
            this.next = null;
        }

        public int getData() {
            return data;
        }
    }
    //单链表属性
    private Node head;
    //初始化
    public Linked(){
        this.head =null;
    }


    @Override
    public void addFirst(int data) {
        Node node = new Node(data);
        if ( this.head == null){
            this.head = node;
        }else {
            node.next = this.head;
            this.head = node;
        }
    }

    @Override
    public void addLast(int data) {
        Node node = new Node(data);
        Node cur = this.head;
        if ( cur == null ){
            this.head = node;
        }else {
            //找尾巴
            while (cur.next!=null){
                cur = cur.next;
            }
            //退出上面循环，cur所指向的位置就是尾节点
            cur.next = node;
        }

    }

    //找到index-1位置的节点
    private Node searchIndex(int index){
        checkIndex(index);
        int count = 0;
        Node cur = this.head;
        while (count < index-1){
            cur = cur.next;
            count++;
        }
        return cur;
    }
    //判断合法性
    private void checkIndex(int index){
        if(index<0||index>getLength()){
            throw new UnsupportedOperationException("index位置不合法");
        }
    }
    @Override
    public boolean addIndex(int index, int data) {
        if ( index==0 ){
            addFirst(data);
            return true;
        }
        Node node = new Node(data);
        Node cur = searchIndex(index);
        node.next = cur.next;
        cur.next = node;
        return true;
    }

    @Override
    public boolean contains(int key) {
        Node cur = this.head;
        while (cur != null){
            if(cur.data == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    private Node searchPrev(int key){
        Node cur = this.head;
        while (cur.next != null){
            if( cur.next.data == key){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
    @Override
    public int remove(int key) {
        if(this.head == null) {
            throw new UnsupportedOperationException("单链表为空");
        }
        int oldData = 0;
        //删除的节点是头结点
        if(this.head.data == key){
            oldData = this.head.data;
            this.head = this.head.next;
            return oldData;
        }
        Node prev = searchPrev(key);
        if(prev == null) {
            //return
            throw new UnsupportedOperationException("没有前驱");
        }
        Node del = prev.next;
        oldData = del.data;
        prev.next = del.next;
        //del = null;
        return oldData;
    }

    @Override
    public void removeAllKey(int key) {
        if(this.head==null){
            return;
        }
        Node prev = this.head;
        Node cur = this.head.next;
        while (cur != null) {
            if(cur.data == key){
                prev.next = cur.next;
                cur = prev.next;
            }else {
                prev = cur;
                cur = cur.next;
            }
        }
        if(this.head.data == key){
            this.head = this.head.next;
        }

    }

    @Override
    public int getLength() {
        if ( this.head == null ) {
            return 0;
        }
        int count = 0;
        Node cur = this.head;
        while (cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }

    @Override
    public void display() {
        Node cur = this.head;
        while (cur!=null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();

    }

    @Override
    public void clear() {
        while (this.head.next != null) {
            Node del = this.head.next;
            this.head.next = del.next;
        }
        this.head = null;

    }


    // 反转一个单链表
    public Node reverseList() {
        Node reverseHead = null;//反转后新节点的头
        Node cur =this.head;//cur代表当前需要反转的结点
        Node prev = null ;//cur的前驱
        while (cur != null){
            Node curNext = cur.next;
            if(curNext == null){
                reverseHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return reverseHead;
    }
    //打印指定节点开始的数据
    public void  show (Node newHead){
        Node cur = newHead;
        while (cur!=null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    //找到单链表的中间节点
    public Node middleNode() {
        Node cur = this.head;
        int len = getLength()/2;
        for (int i = 0; i <len ; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //输入一个链表，输出该链表中倒数第k个结点。
    public Node FindKthToTail(int k) {
        if(this.head == null|| k <= 0 ){//|| k > getLength()
            return null;
        }
        Node fast = this.head;
        Node slow = this.head;
        while (k-1>0){
            if(fast.next != null){
                fast = fast.next;
                k--;
            }else {
                System.out.println("无此节点");
                return null;
            }
        }
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    // 以给定值x为基准将链表分割成两部分
    public Node partition(int x) {
       Node beforeS = null;
       Node beforeE = null;
       Node afterS = null;
       Node afterE = null;
       Node pHead = this.head;
       while (pHead != null){
           Node pHeadNext = pHead.next;
           pHead.next = null;
           if(pHead.data<x){
               if(beforeS == null){
                   beforeS = pHead;
                   beforeE = beforeS;
               }else {
                   beforeE.next = pHead;
                   beforeE =beforeE.next;
               }
           }else {
               if(afterS == null){
                   afterS = pHead;
                   afterE = afterS;
               }else {
                   afterE.next = pHead;
                   afterE = afterE.next;
               }
           }
           pHead = pHeadNext;
       }
       if (beforeS == null){
           return afterS;
       }
       beforeE.next = afterS;//单链表进行拼接
       return beforeS;
    }

    //判断单链表是否有环 I
    public boolean hasCycle() {
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return  true;
            }
        }
        return false;
    }
    //单链表是否有环
    public void  creatLoop(){
        Node cur = this.head;
        while (cur.next != null){
            cur = cur.next;
        }
        cur.next = this.head.next.next;
    }
    //判断单链表是否有环 II
    //给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null
    public Node detectCycle() {
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        //没有环返回null；
        if(fast == null && fast.next == null){
            return null;
        }
        slow = this.head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
