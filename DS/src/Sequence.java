import java.util.Arrays;
//顺序表
public class Sequence implements ISequence {

    private Object[]elem;
    private int usedSize;//有效数据个数
    private static final int DEFAULT_SIZE = 10;
    public Sequence(){
        this.elem = new Object[DEFAULT_SIZE];
        this.usedSize = 0;

    }

    private boolean isFull(){
        if(this.usedSize==this.elem.length){
            return true;
        }
        return false;

      //  return this.usedSize == this.elem.length;等同于上述代码
    }
    @Override
    public boolean add(int pos, Object data) {
        //1·pos位置合法性判断
        if(pos<0||pos>this.usedSize){
            return false;
        }
        //2·判断是否为满
        if(isFull()){
            //二倍扩容
            this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
        }
        //插入
        for (int i =this.usedSize-1; i >= pos ; i--) {
            this.elem[i+1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;
        return true;
    }

    private boolean isEmpty(){
        return this.usedSize == 0;
    }

    @Override
    public int search(Object key) {
        if(isEmpty()){
            return -1;
        }
        for (int i = 0; i <this.usedSize ; i++) {
            if(this.elem[i].equals(key)){
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
        for (int i = 0; i <this.usedSize ; i++) {
            if(this.elem[i].equals(key)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object getPos(int pos) {
        //1·pos位置合法性
        if(pos<0||pos>this.usedSize){
            return null;
        }
        return this.elem[pos];
    }

    @Override
    public Object remove(Object key) {
        int index =search(key);
        if(index == -1){
            return null;
        }
        //保存要删除的值
        Object data = this.elem[index];
        int i;
        for (i = index; i < this.usedSize-1 ; i++) {
            this.elem[i] =this.elem[i+1];
        }
        this.usedSize--;
        this.elem[i+1] = null;

        return data;
    }

    @Override
    public int size() {
        return this.usedSize;
    }

    @Override
    public void display() {
        for (int i = 0; i <this.usedSize ; i++) {
            System.out.print(this.elem[i]+" ");

        }

    }

    //内存回收，防止泄露；
    @Override
    public void clear() {
        for (int i = 0; i <this.usedSize ; i++) {
            this.elem[i]=null;

        }

    }
}
