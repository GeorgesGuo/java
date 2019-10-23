package LinkAndSequence;

import java.util.Arrays;
import java.util.Random;

public class Test01 {
    //节点类
    class Node{
        private int data;
        private Node next;
        //初始化
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    //单链表属性
    private Node head;
    //初始化
    public Test01(){
        this.head =null;
    }


    //排序链表中，删除链表中重复结点，返回链表头指针
    public Node deleteDuplication() {
        Node node = new Node(-1);
        Node cur = this.head;
        Node tmpHead = node;
        while (cur !=null){
            if (cur.next !=null && cur.data == cur.next.data){
                while (cur.next !=null && cur.data == cur.next.data){
                    cur = cur.next;
                }
                cur = cur.next;
                tmpHead .next=cur;
            }else {
                //确定不为重复的结点
                tmpHead.next = cur;
                tmpHead =cur;
                cur = cur.next;
            }
        }
        return node.next;
    }

    public static void main(String[] args) {
        Test01 test01 = new Test01();
        int []array =new int[10];
        int[]tmpArray = new int[array.length];
        Random random = new Random();
        for(int i =0;i<array.length;i++){
            array[i]=random.nextInt(10)+1;
        }
        System.out.println(Arrays.toString(array));
        Test01.Node cur =test01.deleteDuplication();
        System.out.println(cur);
    }
}
