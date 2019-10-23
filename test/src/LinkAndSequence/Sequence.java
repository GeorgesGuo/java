package LinkAndSequence;

import java.util.Arrays;

public class Sequence  implements ISequence{
    private Object[]elem;
    private int uesSize;
    private static final int DEFAULT_SIZE =10;//默认长度

    public Sequence(){
        this.elem = new Object[DEFAULT_SIZE];
        this.uesSize = 0;
    }

    private boolean isFull(){
        if(this.uesSize == this.elem.length ){
            return true;
        }
        return false;
    }
    @Override
    public boolean add(int pos, Object data) {
        if(pos>this.uesSize||pos<0){
            return false;
        }
        if(isFull()){
            this.elem= Arrays.copyOf(this.elem, 2*this.elem.length);
        }
        return false;
    }

    private boolean isEmpty(){
        if(uesSize == 0){
            return true;
        }
        return false;
    }

    @Override
    public int search(Object key) {
        if (isEmpty()){
            return -1;
        }
        for (int i = 0; i <elem.length ; i++) {
            if (this.elem[i].equals ( key)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Object key) {
        if(isEmpty()){
            return false;
        }
        for(int i = 0;i<this.uesSize;i++){
            if (this.elem[i].equals(key)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object getPos(int pos) {
       if (isEmpty()){
           return null;
       }
       if(this.uesSize<pos||pos< 0){
           return null;
       }
        return this.elem[pos];

    }

    @Override
    public Object remove(Object key) {
       int index= search(key);
       if(index == -1){
           return null;
       }
       Object data = this.elem[index];
        int i;
        for ( i = index; i <uesSize-1 ; i++) {
            this.elem[i]= this.elem[i+1];
        }
        this.uesSize--;
        this.elem[i+1] = null;
        return data;
    }

    @Override
    public int size() {
       return this.uesSize;
    }

    @Override
    public void display() {
        for (int i = 0;i<this.uesSize;i++){
            System.out.println(this.elem[i]+" ");
        }

    }

    @Override
    public void clear() {
        for (int i =0; i <this.uesSize ; i++) {
            this.elem [i]=null;
        }
    }
}

