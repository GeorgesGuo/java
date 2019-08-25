public class Test1 {
    public static void main(String[] args) {
        MyDoubleLinked myDoubleLinked = new MyDoubleLinked();
        myDoubleLinked.addFirst(10);
        myDoubleLinked.addFirst(20);
        myDoubleLinked.addFirst(30);
        myDoubleLinked.addFirst(40);
        myDoubleLinked.addFirst(50);
        myDoubleLinked.addLast(66);
        myDoubleLinked.display();
        myDoubleLinked.addIndex(1,11);
        myDoubleLinked.display();
        myDoubleLinked.remove(10);
        myDoubleLinked.display();
    }
    public static void main2(String[] args) {
        Linked linked = new Linked();
        linked.addFirst(10);
        linked.addFirst(20);
        linked.addFirst(30);
        linked.addFirst(40);
        linked.addLast(99);
//        linked.display();
//        linked.addIndex(1,33);
//        linked.display();
//        linked.remove(20);
        linked.display();
//        Linked.Node cur =linked.reverseList();
//        linked.show(cur);
//        Linked.Node cur = linked.middleNode();
//        System.out.println(cur.getData());
//        Linked.Node cur = linked.FindKthToTail(1);
//        System.out.println(cur.getData());
        Linked.Node cur = linked.partition(30);
        linked.show(cur);

    }

    //顺序表
    public static void main1(String[] args) throws InterruptedException {
        Sequence sequence = new Sequence();
        for (int i = 0; i <10 ; i++) {
            sequence.add(i,i);
        }
        sequence.add(3,"gao");
        sequence.display();
        Object res = sequence.remove(8);
        System.out.println(res);
        sequence.display();

        sequence.clear();
        Thread.sleep(1000);

    }


}
