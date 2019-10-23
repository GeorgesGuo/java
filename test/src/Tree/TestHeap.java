package Tree;

import java.util.Arrays;

public class TestHeap implements Heap {
    private int []elem;
    private int usedSize;
    private static final int  DEFAULT_SIZE=10;

    //提供构造函数
    public TestHeap(){
        //初始化
        this.elem=new int[DEFAULT_SIZE];
        this.usedSize=0;
    }
    @Override
    public void AdjustDown(int root, int len) {
        int parent = root;
        int child = 2*parent+1;
        while (child < len){
            if(child+1<len && elem[child]<elem[child+1]){
                ++child;
            }
            //child下标存放的是左右孩子的最大值
            if(elem[child]>elem[parent]){
                //交换
                int tmp = elem[child];
                elem[child]=elem[parent];
                elem[parent]=tmp;
                parent=child;
                child = 2*parent+1;
            }else {
                break;
            }
        }

    }

    //创建大根堆
    @Override
    public void initHeap(int[] array) {
        for (int i = 0 ; i < array.length ; i++){
            this.elem[i]=array[i];
            this.usedSize++;
        }
        for (int i = (array.length-1-1)/2 ; i >= 0; i-- ){
            AdjustDown(i,this.usedSize);
        }

    }

    @Override
    public void AdjustUp(int child) {
        int parent =(child-1)/2;
        while (child>0){
            if(elem[child]>elem[parent]){
                int tmp=elem[child];
                elem[child]=elem[parent];
                elem[parent]=tmp;
                child=parent;
                parent=(child-1)/2;
            }else {
                break;
            }
        }

    }

    //判满
    public boolean isFull(){
        return this.usedSize==this.elem.length;
    }
    @Override
    public void pushHeap(int item) {
        if(isFull()){
            this.elem= Arrays.copyOf(this.elem,2*this.elem.length);
        }
        this.elem[this.usedSize]=item;
        this.usedSize++;
        AdjustUp(this.usedSize-1);

    }


    public boolean isEmpty(){
        return this.usedSize==0;
    }

    @Override
    public int popHeap() {
        if(isEmpty()){
            throw new UnsupportedOperationException("堆为空");
        }
        int oldData = this.elem[0];
        int tmp =this.elem[0];
        this.elem[0]=this.elem[this.usedSize-1];
        this.elem[this.usedSize-1]=tmp;
        usedSize--;
        AdjustDown(0,this.usedSize);
        return oldData;
    }

    @Override
    public int getHeapTop() {
        if (isEmpty()){
            throw new UnsupportedOperationException("堆为空");
        }
        return elem[0];
    }


    //堆排序
    @Override
    public void HeapSort(int []array) {
        //建立大根堆
        for (int i = (array.length-1-1)/2; i >=0 ; i--) {
            AdjustDown(i,this.usedSize);
        }
        int end =this.usedSize-1;
        while (end>0){
            int tmp =this.elem[0];
            this.elem[0]=this.elem[end];
            this.elem[end]=tmp;
            AdjustDown(0,end);
            end--;
        }
    }

    @Override
    public void show() {
        for (int i = 0; i <this.usedSize ; i++) {
            System.out.println(elem[i]+" ");
        }
    }
}
