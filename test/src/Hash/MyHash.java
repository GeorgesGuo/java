package Hash;

import java.util.Random;

//搜索算法
public class MyHash {

    private static class Node{
        int key;
        int value;
        Node next;
    }
    //负载因子
    private static final  double LOAD_FACTOR_THRESHOLD = 0.75;
    private Node[]array;
    private int size;
    MyHash(){
        array = new Node[16];
        size = 0;
    }

    public int getIndex(int key){
        //key必须合法（>0）
        return key%array.length;
    }
    public int get(int key){
        int index = getIndex(key);

        Node cur = array[index];
        while (cur!=null){
            if(cur.key == key){
                return cur.value;
            }
            cur = cur.next;
        }
        return -1;
    }
    public int put(int key,int value){
        //考虑负载因子
        if(1.0 *size / array.length >= LOAD_FACTOR_THRESHOLD){
            adjustCapacity();
        }

        int index = getIndex(key);
        //保证key不在该index下的链表中（保证key不重复）
        Node cur =array[index];
        while (cur!=null){
            if (cur.key == key){
                int v =cur.value;
                cur.value = value;
                return v;
            }
            cur = cur.next;
        }
        Node newNode = new Node();
        newNode.key = key;
        newNode.value = value;
        size ++;

        newNode.next = array[index];
        array[index] = newNode;

        return -1;

    }


    private void moveKeyValue(Node[] array,int key ,int value){
        int index = key % array.length;
        Node newNode = new Node();
        newNode.key = key;
        newNode.value = value;
        newNode.next = array[index];
        array[index] = newNode;
    }

    private void adjustCapacity(){
        Node[]array = new Node[this.array.length*2];
        for (int i = 0; i <this.array.length ; i++) {
            Node cur =this.array[i];
            while (cur!= null){
                moveKeyValue(array,cur.key,cur.value);
                cur = cur.next;
            }
        }
        this.array=array;
    }

    public static void main(String[] args) {
        MyHash hash = new MyHash();
        Random random = new Random(20190827);
        for (int i = 0; i <100 ; i++) {
            int key =random.nextInt(200);
            hash.put(key,key);
        }
        System.out.println(hash.toString());
    }

}
