public class Test1 {
    public static void main(String[] args) {
        Linked linked = new Linked();
        linked.addFirst(10);
        linked.addFirst(20);
        linked.addFirst(30);
        linked.addFirst(40);
        linked.addLast(99);
        linked.display();
        linked.addIndex(1,33);
        linked.display();
        linked.remove(20);
        linked.display();

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
