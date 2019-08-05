package test.thread;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

class goods{
    private int maxGoodsNum;
    private Condition producerQueue = Lock.newCondition();
}

public class MultiThreadPC {

}
